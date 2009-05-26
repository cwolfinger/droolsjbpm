package org.drools.xml;

/*
 * 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.ProviderInitializationException;
import org.drools.RuleBaseConfiguration;
import org.drools.RuntimeDroolsException;
import org.drools.base.ClassFieldAccessorStore;
import org.drools.base.evaluators.TimeIntervalParser;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderConfiguration;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.KnowledgeBuilderProvider;
import org.drools.builder.impl.KnowledgeBuilderProviderImpl;
import org.drools.compiler.DrlParser;
import org.drools.compiler.PackageBuilder;
import org.drools.compiler.PackageBuilderConfiguration;
import org.drools.compiler.ReturnValueDescr;
import org.drools.compiler.TypeDeclarationError;
import org.drools.definition.KnowledgePackage;
import org.drools.definitions.impl.KnowledgePackageImp;
import org.drools.factmodel.ClassDefinition;
import org.drools.facttemplates.FactTemplate;
import org.drools.io.InternalResource;
import org.drools.lang.DroolsSoftKeywords;
import org.drools.lang.descr.AccessorDescr;
import org.drools.lang.descr.AccumulateDescr;
import org.drools.lang.descr.ActionDescr;
import org.drools.lang.descr.AndDescr;
import org.drools.lang.descr.AttributeDescr;
import org.drools.lang.descr.BaseDescr;
import org.drools.lang.descr.BehaviorDescr;
import org.drools.lang.descr.CollectDescr;
import org.drools.lang.descr.CutDescr;
import org.drools.lang.descr.DeclarativeInvokerDescr;
import org.drools.lang.descr.EntryPointDescr;
import org.drools.lang.descr.EqvDescr;
import org.drools.lang.descr.EvalDescr;
import org.drools.lang.descr.EvaluatorBasedRestrictionDescr;
import org.drools.lang.descr.ExistsDescr;
import org.drools.lang.descr.FactTemplateDescr;
import org.drools.lang.descr.FieldAccessDescr;
import org.drools.lang.descr.FieldBindingDescr;
import org.drools.lang.descr.FieldConstraintDescr;
import org.drools.lang.descr.ForAnyDescr;
import org.drools.lang.descr.ForallDescr;
import org.drools.lang.descr.FromDescr;
import org.drools.lang.descr.FunctionCallDescr;
import org.drools.lang.descr.FunctionDescr;
import org.drools.lang.descr.FunctionImportDescr;
import org.drools.lang.descr.GlobalDescr;
import org.drools.lang.descr.HedgeDescr;
import org.drools.lang.descr.ImpliesDescr;
import org.drools.lang.descr.ImportDescr;
import org.drools.lang.descr.LiteralRestrictionDescr;
import org.drools.lang.descr.MethodAccessDescr;
import org.drools.lang.descr.NotDescr;
import org.drools.lang.descr.OrDescr;
import org.drools.lang.descr.PackageDescr;
import org.drools.lang.descr.PackageDescrDumper;
import org.drools.lang.descr.PatternDescr;
import org.drools.lang.descr.PatternSourceDescr;
import org.drools.lang.descr.PredicateDescr;
import org.drools.lang.descr.ProcessDescr;
import org.drools.lang.descr.QualifiedIdentifierRestrictionDescr;
import org.drools.lang.descr.QueryDescr;
import org.drools.lang.descr.Restriction;
import org.drools.lang.descr.RestrictionConnectiveDescr;
import org.drools.lang.descr.ReturnValueRestrictionDescr;
import org.drools.lang.descr.RuleDescr;
import org.drools.lang.descr.SlidingWindowDescr;
import org.drools.lang.descr.TypeDeclarationDescr;
import org.drools.lang.descr.TypeFieldDescr;
import org.drools.lang.descr.VariableRestrictionDescr;
import org.drools.lang.descr.XorDescr;
import org.drools.rule.Package;
import org.drools.rule.TypeDeclaration;
import org.drools.rule.TypeDeclaration.DurationAccessorSetter;
import org.drools.rule.TypeDeclaration.TimestampAccessorSetter;
import org.drools.spi.InternalReadAccessor;
import org.drools.util.ReflectiveVisitor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * This utility will take a AST of a rule package, and emit XML. This can be
 * used in porting from DRL to XML.
 * 
 * @author <a href="mailto:jayaramcs@gmail.com">Author Jayaram C S</a>
 */
public class RuleMLDumper extends ReflectiveVisitor implements
		PackageDescrDumper, DroolsDescrVisitor {

	static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

	static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";

	static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";

	static final String NAFFOLOGEQ = "naffologeq";

	static final DocumentBuilderFactory naffologeqFactory = DocumentBuilderFactory
			.newInstance();

	static final Map<String, DocumentBuilderFactory> validators = new HashMap<String, DocumentBuilderFactory>();

	private DocumentBuilderFactory doxFactory = DocumentBuilderFactory
			.newInstance();

	private Document dox;

	private RuleMLContext context;
	
	
	
	private boolean IMPERFECT = false;

	//	
	//	
	// {
	// validators.put(NAFFOLOGEQ, naffologeqFactory);
	//				
	// for (String lang : validators.keySet()) {
	// DocumentBuilderFactory factory = validators.get(lang);
	// factory.setNamespaceAware(true);
	// factory.setValidating(true);
	//		
	// factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
	//			
	// String resLoc = "org/ruleml/"+lang+".xsd";
	// URL res;
	// try {
	//				
	// res = ((ClassPathResource)
	// ResourceFactory.newClassPathResource(resLoc)).getURL();
	// File schemaFile = new File(res.getFile());
	//				
	// factory.setAttribute(JAXP_SCHEMA_SOURCE, schemaFile.toString());
	//				
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//								
	//			
	//			
	// }
	//		
	// }
	//	
	//	
	//	

	public RuleMLDumper() {
		try {

			doxFactory.setNamespaceAware(true);
			dox = doxFactory.newDocumentBuilder().newDocument();
			context = new RuleMLContext();

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IllegalArgumentException x) {
			x.printStackTrace();
		}
	}

	// public void test() {
	//		
	// for (String lang : validators.keySet()) {
	//			
	// DocumentBuilderFactory factory = validators.get(lang);
	//			
	//									
	// ByteArrayOutputStream bos = new ByteArrayOutputStream();
	// format(dox, bos);
	// ByteArrayInputStream bs = new ByteArrayInputStream(
	// bos.toByteArray()
	// );
	//				
	// try {
	//					
	// DocumentBuilder dob = factory.newDocumentBuilder();
	// dob.setErrorHandler(new ErrorHandler () {
	//
	// public void error(SAXParseException exception)
	// throws SAXException {
	// System.err.println("Error");
	// exception.printStackTrace();
	//								
	// }
	//
	// public void fatalError(SAXParseException exception)
	// throws SAXException {
	// System.err.println("Fatal Error");
	// exception.printStackTrace();
	//								
	// }
	//
	// public void warning(SAXParseException exception)
	// throws SAXException {
	// System.err.println("Warning");
	// exception.printStackTrace();
	// }
	//							
	// });
	// dob.parse(bs);
	// System.out.println(lang.toUpperCase()+ "\t\t\t\t true\n");
	//					
	// } catch (SAXException e) {
	//					
	// System.out.println(lang.toUpperCase()+ "\t\t\t\t false\n");
	// System.out.println(e.toString());
	//					
	// } catch (IOException e) {
	// //
	// System.out.println(e.toString());
	// } catch (ParserConfigurationException e) {
	// System.out.println(e.toString());
	//				
	// }
	//											
	//			  
	// }
	//		
	// }

	// public void test2(String schemaId) {
	//		
	//		
	// String resLoc = "org/ruleml/"+schemaId+".xsd";
	// URL schemaURL = null;
	// try {
	//			
	// schemaURL = ((ClassPathResource)
	// ResourceFactory.newClassPathResource(resLoc)).getURL();
	//			
	// } catch (IOException e) {
	// //
	// e.printStackTrace();
	// }
	//		
	// ByteArrayOutputStream bos = new ByteArrayOutputStream();
	// format(dox, bos);
	// ByteArrayInputStream bs = new ByteArrayInputStream(
	// bos.toByteArray()
	// );
	//		
	//		
	// Schema schema = null;
	// try {
	// String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
	// SchemaFactory factory = SchemaFactory.newInstance(language);
	// schema = factory.newSchema(schemaURL);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// try {
	// Validator validator = schema.newValidator();
	// SAXSource source = new SAXSource(
	// new InputSource(bs));
	//
	//
	// validator.validate(source);
	// System.out.println();
	// System.out.println("Validation passed.");
	//
	// } catch (Exception e) {
	// // catching all validation exceptions
	// System.out.println();
	// System.out.println(e.toString());
	// }
	//			  			  			  			    	
	// }

	public synchronized String dump(InputStream drl, InputStream config) {

		try {

			Properties props = new Properties();
			if (config != null) {
				props.load(config);
				// load evaluators (static)
			}
			KnowledgeBuilderConfiguration pbConf = new PackageBuilderConfiguration(
					props);

			DrlParser parser = new DrlParser();
			PackageDescr pkD = parser.parse(drl);
			

			testAndLoadDynamicTypes(pkD,pbConf);

			return dump(pkD);

		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}

	}

	private void testAndLoadDynamicTypes(PackageDescr pkD, KnowledgeBuilderConfiguration knowledgeBuilderConfiguration) {
		if (pkD.getTypeDeclarations().size() > 0) {

			PackageBuilder pkBuilder = new PackageBuilder((PackageBuilderConfiguration) knowledgeBuilderConfiguration );
			pkBuilder.addPackage(pkD);
			List<KnowledgePackage> pkgs = new ArrayList<KnowledgePackage>(1);
			Package[] pkArray = pkBuilder.getPackages();
			for (int j = 0; j < pkArray.length; j++)
				pkgs.add(new KnowledgePackageImp(pkArray[j]));

			final KnowledgeBase kbase = KnowledgeBaseFactory
					.newKnowledgeBase(new RuleBaseConfiguration());
			kbase.addKnowledgePackages(pkgs);

			context.setKBase(kbase);
		}
	}

	public String dump(PackageDescr packageDescr) {
		return dump(packageDescr, new PackageBuilderConfiguration() ,"out.ruleml");
	}

	public synchronized String dump(final PackageDescr packageDescr,
			KnowledgeBuilderConfiguration knowledgeBuilderConfiguration, String fileName) {

		testAndLoadDynamicTypes(packageDescr,knowledgeBuilderConfiguration);

		this.visitPackageDescr(packageDescr);

//		ByteArrayOutputStream bos = new ByteArrayOutputStream();
//		format(dox, bos);

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fileName);
			format(dox, fos);
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// 
			e.printStackTrace();
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}

//		String xml = bos.toString();

//		return xml;
		return format(dox);
	}
	
	
	
	private void decorateWithAttribs(Element elem, BaseDescr descr) {
		if (descr.getLabel() != null)
			attachId(elem,descr.getLabel(),false);
		
		if (descr.isCutter()) {
			if (IMPERFECT) {
				elem.setAttribute("cut","true");
			} else {
				Element cut = dox.createElement("cut");										
				elem.appendChild(dox.createComment("unsupported attribute - "+format(cut)));
			}
		}
		
		String kindS = descr.getParams();	
			if (kindS != null) {					
				if (IMPERFECT) {
					elem.setAttribute("kind",kindS);
				} else {
					Element kind = dox.createElement("kind");				
					kind.setTextContent(kindS);			
					elem.appendChild(dox.createComment("unsupported attribute - "+format(kind)));
				}
			}
									
		String priorS = descr.getPrior();
			if (priorS != null) {
				Element degree = dox.createElement("degree");
					Element data = dox.createElement("Data");
						data.setTextContent(priorS);
						degree.appendChild(data);
				if (IMPERFECT) {
					elem.appendChild(degree);
				} else {
					elem.appendChild(dox.createComment(format(degree)));
				}
			}
	}
	

	public void visitAndDescr(final AndDescr descr) {
		Element and = dox.createElement("And");
			decorateWithAttribs(and,descr);

//		if (descr.getLabel() != null && !descr.getLabel().equals(""))
//			attachId(and, descr.getLabel(), false);
//
//		if (descr.getParams() != null && !descr.getParams().equals("")) {
//			and.setAttribute("kind", descr.getParams());
//		}

		// At pattern level, a field binding is always ALSO followed by its
		// Restriction
		// So we have to work around this...

		visitChildrenExcludeDuplicates(and, checkListType(descr.getDescrs()));

		context.getCurrentElement().appendChild(and);
	}

	@SuppressWarnings("unchecked")
	private List<? extends BaseDescr> checkListType(List descrs) {
		return descrs;
	}

	public void visitAttributeDescr(final AttributeDescr attributeDescr) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void visitVariableRestrictionDescr(
			final VariableRestrictionDescr descr) {
		Element prevElem = context.getCurrentElement();

		visitEvaluatorBasedRestrictionDescr(descr);

		Element atom = context.setCurrentElement(prevElem); // set by visitEBRD

		buildAccessorPathExpression(atom, descr.getText());

		if (descr.isNegated()) {
			Element neg = dox.createElement("Neg");
			neg.appendChild(atom);
			context.getCurrentElement().appendChild(neg);
		} else {
			context.getCurrentElement().appendChild(atom);
		}

	}

	public void visitPatternDescr(final PatternDescr descr) {

		context.setClassType(descr.getObjectType());

		String varName = "";
		if (descr.getIdentifier() != null) {
			varName = context.getRuleName() + "." + descr.getIdentifier();
		} else {
			varName = context.getRuleName() + "." + context.getClassType();
		}

		varName = context.trySetCurrentObjectVariable(varName);
		// getter, so it is validated
		// context.addVariable(varName, "");

		Element atom = dox.createElement("Atom");
		attachId(atom, context.getCurrentObjectVariable(), true);

		Element pattern = dox.createElement("Rel");
		pattern.setTextContent(descr.getObjectType());
		atom.appendChild(pattern);

		Element patternDefinition = dox.createElement("Reify");
		FieldConstraintDescr typeDescr = new FieldConstraintDescr("class");
		LiteralRestrictionDescr classRestr = new LiteralRestrictionDescr("isA", false, "",
				context.getMappedClass(descr.getObjectType()), LiteralRestrictionDescr.TYPE_CLASS);
			classRestr = (LiteralRestrictionDescr) inheritDecorations(classRestr, descr);
		typeDescr.addRestriction(classRestr);
			
		descr.getConstraint().addDescrFirst(typeDescr);

		visitChild(patternDefinition, (BaseDescr) descr.getConstraint());
		atom.appendChild(patternDefinition);

		context.getCurrentElement().appendChild(atom);
	}

	private Element buildGetterExpression(String fldName, String var) {
		Element expr = dox.createElement("Expr");
		expr.setAttribute("in", "yes");
		Element functor = dox.createElement("Fun");
		functor.setTextContent("get" + fldName.substring(0, 1).toUpperCase()
				+ fldName.substring(1));
		attachAsOp(expr, functor);

		Element varArg = dox.createElement("Var");
		varArg.setTextContent(var);
		expr.appendChild(varArg);

		return expr;
	}

	private void attachAsOp(Element father, Element child) {
		Element op = dox.createElement("op");
		op.appendChild(child);
		father.appendChild(op);
	}

	public void visitFieldBindingDescr(final FieldBindingDescr descr) {

		String varName = context.currentObjectVariable + "."
				+ descr.getIdentifier();

		context.setCurrentField(descr.getFieldConstraint().getFieldName());
		context.trySetCurrentFieldVariable(varName);

		// bypass the fieldConstraint
		List<? extends BaseDescr> list = checkListType(descr
				.getFieldConstraint().getRestrictions());
			
//			for (BaseDescr d : list) {
//				inheritDecorations(d,descr);
//			}
		
		if (list.size() > 0) {
			visitChildren(context.getCurrentElement(), list);
		} else {
			// Unconstrained field binding		Object( $var : field )
			Element atom = dox.createElement("Atom");
				decorateWithAttribs(atom,descr);
			Element rel = dox.createElement("Rel");
			attachAsOp(atom, rel);

			Element slot = dox.createElement("slot");
			Element field = dox.createElement("Ind");
			field.setTextContent(context.getCurrentField());
			slot.appendChild(field);

			Element value = dox.createElement("Var");
			value.setTextContent(context.getCurrentFieldVariable());
			slot.appendChild(value);

			atom.appendChild(slot);

			context.getCurrentElement().appendChild(atom);
		}

	}

	private BaseDescr inheritDecorations(BaseDescr target, BaseDescr source) {
		// TODO Auto-generated method stub
		target.setLabel(source.getLabel());
		target.setCutter(source.isCutter());
		target.setParams(source.getParams());
		//@TODO @FIXME
		target.setPrior(source.getPrior());
		
		return target;
	}

	public void visitFieldConstraintDescr(FieldConstraintDescr descr) {

		context.setCurrentField(descr.getFieldName());
		context.trySetCurrentFieldVariable(null);

		List<? extends BaseDescr> list = checkListType(descr.getRestrictions());
//		for (BaseDescr d : list) {
//			inheritDecorations(d,descr);
//		}
		
		if (list.size() > 0) {
			visitChildren(context.getCurrentElement(), list);
		} else {
			// Empty field restriction, nothing to do
			throw new RuntimeDroolsException(
					"Error: impossible to find an useless field constraint "
							+ descr.toString());
		}

	}

	//
	public void visitCollectDescr(final CollectDescr descr) {
		System.err.println("RuleML does not support COLLECT construct");
	}

	//
	public void visitAccumulateDescr(final AccumulateDescr descr) {
		System.err.println("RuleML does not support ACCUMULATE construct");
	}

	//
	public void visitFromDescr(final FromDescr descr) {
		System.err.println("RuleML does not support FROM construct");
	}

	//
	public void visitForallDescr(final ForallDescr descr) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void visitEvalDescr(final EvalDescr descr) {
		Element atom = dox.createElement("Atom");
			decorateWithAttribs(atom,descr);
		
		Element eval = dox.createElement("Rel");
		eval.setTextContent("eval");
		attachAsOp(atom, eval);

		Element expr = dox.createElement("Expr");
		expr.setAttribute("in", "yes");
		Element fun = dox.createElement("Fun");
		fun.setTextContent("eval");
		Element data = dox.createElement("Data");
		data.setTextContent(descr.getContent().toString());
		expr.appendChild(fun);
		expr.appendChild(data);
		atom.appendChild(expr);
		context.getCurrentElement().appendChild(atom);
	}

	//
	public void visitExistsDescr(final ExistsDescr descr) {
		// TODO
		throw new UnsupportedOperationException();
	}

	//

	public void visitFunctionDescr(final FunctionDescr functionDescr) {
		// TODO
		throw new UnsupportedOperationException();
	}

	//

	public void visitLiteralRestrictionDescr(final LiteralRestrictionDescr descr) {

		Element prevElem = context.getCurrentElement();

		visitEvaluatorBasedRestrictionDescr(descr);

		Element atom = context.setCurrentElement(prevElem); // set by visitEBRD

		if (descr.getValue() != null) {
			Element data = dox.createElement("Ind");
			data.setTextContent(descr.getValue().toString());
			data.setAttribute("type", reflectType(descr.getType()));
			atom.appendChild(data);
		}

		if (descr.isNegated()) {
			Element neg = dox.createElement("Neg");
			neg.appendChild(atom);
			context.getCurrentElement().appendChild(neg);
		} else {
			context.getCurrentElement().appendChild(atom);
		}
	}

	private String reflectType(int type) {
		switch (type) {
		case LiteralRestrictionDescr.TYPE_BOOLEAN:
			return Boolean.class.getName();
		case LiteralRestrictionDescr.TYPE_NUMBER:
			return Number.class.getName();
		case LiteralRestrictionDescr.TYPE_STRING:
			return String.class.getName();
		case LiteralRestrictionDescr.TYPE_OBJECT:
			return Object.class.getName();
		case LiteralRestrictionDescr.TYPE_CLASS:
			return Class.class.getName();
		case LiteralRestrictionDescr.TYPE_NULL:
			throw new RuntimeException("Found literal of type null");
		default:
			throw new RuntimeException("Found literal of type unknown " + type);
		}
	}

	//
	public void visitQualifiedIdentifierRestrictionDescr(
			final QualifiedIdentifierRestrictionDescr descr) {

		Element prevElem = context.getCurrentElement();

		visitEvaluatorBasedRestrictionDescr(descr);

		Element atom = context.setCurrentElement(prevElem); // set by visitEBRD

		// Element atom = dox.createElement("Atom");
		//    	
		// Element rel = dox.createElement("Rel");
		// rel.setTextContent(descr.getEvaluator());
		// attachAsOp(atom,rel);
		//  	
		//  		
		// Element slot = dox.createElement("slot");
		// Element field = dox.createElement("Ind");
		// field.setTextContent(context.getCurrentField());
		// slot.appendChild(field);
		//  	
		// Element value = dox.createElement("Var");
		// value.setTextContent(context.getCurrentObjectVariable());
		// slot.appendChild(value);
		//  		
		// String varField = context.getCurrentFieldVariable();
		// if (varField == null) {
		//  				  				  			
		// atom.appendChild(slot);
		//  			
		// } else {
		// context.addVariableDefinition(varField, buildEquality(varField,
		// slot));
		//  			
		// Element var = dox.createElement("Var");
		// var.setTextContent(varField);
		// atom.appendChild(var);
		// }

		buildAccessorPathExpression(atom, descr.getText());

		if (descr.isNegated()) {
			Element neg = dox.createElement("Neg");
			neg.appendChild(atom);
			context.getCurrentElement().appendChild(neg);
		} else {
			context.getCurrentElement().appendChild(atom);
		}
	}

	private void buildAccessorPathExpression(Element atom, String text) {

		LinkedList<String> steps = new LinkedList<String>();
		StringTokenizer tok = new StringTokenizer(text, ".");
		while (tok.hasMoreTokens())
			steps.addFirst(tok.nextToken());

		String root = steps.getLast();
		String candidateVar = context.contextualizeVar(root);

		if (root.equals("this")) {
			// this is replaced by the current object variable
			steps.removeLast();
			steps.addLast(context.getCurrentObjectVariable());
		} else if (!context.isVariable(candidateVar)) {
			// supposed to be an implicit "this"
			steps.addLast(context.getCurrentObjectVariable());
		} else {
			// must be a known variable
			steps.removeLast();
			steps.addLast(candidateVar);
		}

		Element expr = walkPath(steps);

		atom.appendChild(expr);
	}

	private Element walkPath(LinkedList<String> steps) {
		String source = steps.removeFirst();

		Element ans = null;

		if (steps.size() > 0) {
			// there are more steps, so this is a getter
			Element expr = dox.createElement("Expr");
			Element fun = dox.createElement("Fun");
			source = "get" + source.substring(0, 1).toUpperCase()
					+ source.substring(1);
			fun.setTextContent(source);
			expr.appendChild(fun);

			expr.appendChild(walkPath(steps));

			ans = expr;

		} else {

			ans = dox.createElement("Var");
			ans.setTextContent(source);
			// will do the normalization earlier

		}

		return ans;
	}

	//
	public void visitNotDescr(final NotDescr descr) {

		Element neg = dox.createElement("Neg");
			decorateWithAttribs(neg,descr);

		visitChildren(neg, checkListType(descr.getDescrs()));

		context.getCurrentElement().appendChild(neg);
	}

	public void visitOrDescr(final OrDescr descr) {
		Element or = dox.createElement("Or");
			decorateWithAttribs(or,descr);

//		if (descr.getLabel() != null && !descr.getLabel().equals(""))
//			attachId(or, descr.getLabel(), false);
//
//		if (descr.getParams() != null && !descr.getParams().equals("")) {
//			or.setAttribute("kind", descr.getParams());
//		}

		visitChildren(or, checkListType(descr.getDescrs()));

		context.getCurrentElement().appendChild(or);
	}

	public void visitPackageDescr(final PackageDescr packageDescr) {

		context.setPackageName(packageDescr.getName());

		Element root = dox.createElement("RuleML");
		root.setAttribute("xmlns", "http://www.ruleml.org/0.91/xsd");
		root.setAttribute("xmlns:xs", "http://www.w3.org/2001/XMLSchema");
		root.setAttribute("xmlns:xsi",
				"http://www.w3.org/2001/XMLSchema-instance");
		root
				.setAttribute("xsi:schemaLocation",
						"http://www.ruleml.org/0.91/xsd http://www.ruleml.org/0.91/xsd/naffologeq.xsd");

		attachId(root,"org.drools.DRL",false);
		
		// Assert rules in a package
		Element elassert = dox.createElement("Assert");
		Element ruleBase = dox.createElement("Rulebase");

		attachId(ruleBase, packageDescr.getName(), false);

		// visitChildren(elassert,packageDescr.getAttributes());
		// visitChildren(elassert,packageDescr.getFactTemplates());
		// visitChildren(elassert,packageDescr.getFunctionImports());
		// visitChildren(elassert,packageDescr.getFunctions());
		// visitChildren(elassert,packageDescr.getGlobals());
		visitChildren(elassert, packageDescr.getImports());
		visitChildren(elassert, packageDescr.getTypeDeclarations());
		visitChildren(ruleBase, packageDescr.getRules());

		elassert.appendChild(ruleBase);
		root.appendChild(elassert);
		dox.appendChild(root);
	}

	public void visitPredicateDescr(final PredicateDescr descr) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void visitRestrictionConnectiveDescr(
			final RestrictionConnectiveDescr descr) {
		//Element atom = dox.createElement("Atom");
		//Element reify = dox.createElement("Reify");
		Element connective = null;
		if (descr.getConnective() == RestrictionConnectiveDescr.AND)
			connective = dox.createElement("And");
		else if (descr.getConnective() == RestrictionConnectiveDescr.OR)
			connective = dox.createElement("Or");
		else
			throw new UnsupportedOperationException("Found unknown connective "
					+ descr.getConnective());
		
		decorateWithAttribs(connective,descr);
		
		visitChildren(connective, descr.getRestrictions());

		//reify.appendChild(connective);
		//atom.appendChild(reify);
		//context.getCurrentElement().appendChild(atom);
		context.getCurrentElement().appendChild(connective);
	}

	public void visitReturnValueRestrictionDescr(
			final ReturnValueRestrictionDescr descr) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void visitRuleDescr(final RuleDescr descr) {

		context.setRuleName(descr.getName());

		String priorS = null;
		String modeS = null;
		String kindS = null;

		AttributeDescr priorA = descr.getAttributes().get(
				DroolsSoftKeywords.PRIOR);
		if (priorA != null)
			priorS = priorA.getValue();

		AttributeDescr modeA = descr.getAttributes().get(
				DroolsSoftKeywords.ENTAIL);
		if (modeA != null)
			modeS = modeA.getValue();

		AttributeDescr kindA = descr.getAttributes()
				.get(DroolsSoftKeywords.KIND);
		if (kindA != null)
			kindS = kindA.getValue();

		Element arrow = null;
		if (modeS != null && modeS.equalsIgnoreCase("equivalence")) {
			arrow = dox.createElement("Equivalent");
		} else {
			arrow = dox.createElement("Implies");
		}
		
		//    	    	
		arrow.setAttribute("direction", "forward");
		
		
		if (kindS != null) {
			Element kind = dox.createElement("kind");				
				kind.setTextContent(kindS);					
			if (IMPERFECT) {
				arrow.appendChild(kind);
			} else {
				arrow.appendChild(dox.createComment(format(kind)));
			}
		}
		
		
		attachId(arrow, descr.getName(), false);

		
		if (priorS != null) {
			Element degree = dox.createElement("degree");
				Element data = dox.createElement("Data");
					data.setTextContent(priorS);
					degree.appendChild(data);
			if (IMPERFECT) {
				arrow.appendChild(degree);
			} else {
				arrow.appendChild(dox.createComment(format(degree)));
			}
		}
		//    	
		//    	
		//    	
		Element body = dox.createElement("body");
		visitChild(body, descr.getLhs());
		arrow.appendChild(body);

		Element head = dox.createElement("head");
		Element atom = dox.createElement("Atom");
		atom.appendChild(dox.createElement("Rel"));
		Element cons = dox.createElement("Data");
		cons.setTextContent(descr.getConsequence().toString().trim());
		atom.appendChild(cons);
		head.appendChild(atom);
		arrow.appendChild(head);
		//    

		Element forall = dox.createElement("Forall");
		for (String varS : context.getVariables()) {
			Element decl = dox.createElement("declare");
			Element var = dox.createElement("Var");
			var.setAttribute("type", context.getVarType(varS));
			var.setTextContent(varS);
			decl.appendChild(var);
			forall.appendChild(decl);
		}

		Element formula = dox.createElement("formula");
		formula.appendChild(arrow);
		forall.appendChild(formula);

		context.getCurrentElement().appendChild(forall);

	}

	public void visitQueryDescr(final QueryDescr descr) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void format(Node dox, OutputStream out) {

		try {

			// create DOMSource for source XML document
			Source xmlSource = new DOMSource(dox);

			Result result = new StreamResult(new OutputStreamWriter(out,
					"UTF-8"));

			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			transformerFactory.setAttribute("indent-number", 4);

			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			transformer.setOutputProperty("indent", "yes"); // Java XML Indent

			// transform and deliver content to client
			transformer.transform(xmlSource, result);
		} catch (Exception e) {

		}

	}

	private void attachId(Element element, String label, boolean isVar) {
		Element oid = dox.createElement("oid");
		Element holder = dox.createElement(isVar ? "Var" : "Data");
		
		holder.setTextContent(label);
		oid.appendChild(holder);
		element.appendChild(oid);
	}

	protected void visitChildren(Element curElem,
			List<? extends BaseDescr> children) {
		Element prevEl = context.getCurrentElement();
		for (BaseDescr child : children) {
			context.setCurrentElement(curElem);
			visit(child);
		}
		context.setCurrentElement(prevEl);
	}

	protected void visitChildrenExcludeDuplicates(Element curElem,
			List<? extends BaseDescr> children) {
		Element prevEl = context.getCurrentElement();
		BaseDescr previous = null;
		for (BaseDescr child : children) {
			context.setCurrentElement(curElem);

			if (previous != null && previous instanceof FieldBindingDescr) {
				if (((FieldBindingDescr) previous).getFieldConstraint() != child) {
					// VISIT THE CHILD ONLY IF IT IS HAS NOT YET BEEN...
					visit(child);
				}

			} else {
				visit(child);
			}
			previous = child;
		}
		context.setCurrentElement(prevEl);
	}

	protected void visitChild(Element curElem, BaseDescr child) {
		Element popEl = context.getCurrentElement();
		context.setCurrentElement(curElem);
		visit(child);
		context.setCurrentElement(popEl);
	}

	public void visitAccessorDescr(AccessorDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitActionDescr(ActionDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitBehaviorDescr(BehaviorDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitCutDescr(CutDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitDeclarativeInvokerDescr(DeclarativeInvokerDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitEntryPointDescr(EntryPointDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitEqvDescr(EqvDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitEvaluatorBasedRestrictionDescr(
			EvaluatorBasedRestrictionDescr descr) {

		Element atom = dox.createElement("Atom");
			decorateWithAttribs(atom,descr);
			
		context.setCurrentElement(atom);

		Element rel = dox.createElement("Rel");
		rel.setTextContent(descr.getEvaluator());
		attachAsOp(atom, rel);

		Element slot = dox.createElement("slot");
		Element field = dox.createElement("Ind");
		field.setTextContent(context.getCurrentField());
		slot.appendChild(field);

		Element value = dox.createElement("Var");
		if (context.getCurrentFieldVariable() != null)
			value.setTextContent(context.getCurrentFieldVariable());
		slot.appendChild(value);

		atom.appendChild(slot);

	}

	public void visitFactTemplateDescr(FactTemplateDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitFieldAccessDescr(FieldAccessDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitForAnyDescr(ForAnyDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitFunctionCallDescr(FunctionCallDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitFunctionImportDescr(FunctionImportDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitGlobalDescr(GlobalDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitHedgeDescr(HedgeDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitImportDescr(ImportDescr descr) {
		String qName = descr.getTarget();
		String name = qName.substring(qName.lastIndexOf('.') + 1);

		context.mapClass(name, qName);
	}

	public void visitMethodAccessDescr(MethodAccessDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitPatternSourceDescr(PatternSourceDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitProcessDescr(ProcessDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitRestriction(Restriction descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitReturnValueDescr(ReturnValueDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitSlidingWindowDescr(SlidingWindowDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public boolean isEmpty(String string) {
		return (string == null || string.trim().length() == 0);
	}

	public void visitTypeDeclarationDescr(TypeDeclarationDescr descr) {
		context.mapClass(descr.getTypeName(), context.getPackageName() + "."
				+ descr.getTypeName());

	}

	public void visitTypeFieldDescr(TypeFieldDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitXorDescr(XorDescr descr) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void visitImpliesDescr(ImpliesDescr descr) {
		// No body / head element wrappers to denote it is just an operator
		Element imp = dox.createElement("Implies");
			decorateWithAttribs(imp,descr);

		if (descr.getLabel() != null && !descr.getLabel().equals(""))
			attachId(imp, descr.getLabel(), false);

		if (descr.getParams() != null && !descr.getParams().equals("")) {
			imp.setAttribute("kind", descr.getParams());
		}

		// At pattern level, a field binding is always ALSO followed by its
		// Restriction
		// So we have to work around this...
		visitChildren(imp, checkListType(descr.getDescrs()));

		context.getCurrentElement().appendChild(imp);
	}

	
	
	
	private String format(Node node) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		format(node,baos);
		
		String ans = baos.toString();
		
		if (! (node instanceof Document)) {
			int last = ans.indexOf('>'); 
			ans = ans.substring(Math.min(last+1,ans.length()));
		}
		return ans;
	}
	
	
	
	
	
	
	
	
	
	private class RuleMLContext {

		private Element currentElement;

		private String ruleName;

		private String classType;

		private String currentObjectVariable;

		private String currentField;

		private String currentFieldVariable;

		private Map<String, String> variables = new HashMap<String, String>();

		private Map<String, String> classMap = new HashMap<String, String>();

		private String packageName;

		private KnowledgeBase kBase;

		public String validateVariable(String id) {
			if (variables.containsKey(id)) {

				int idx = id.lastIndexOf("_");
				if (idx < 0) {
					id = id + "_1";
				} else {
					String tail = id.substring(idx + 1);
					try {
						int cod = Integer.valueOf(tail) + 1;
						id = id.substring(0, idx) + "_" + cod;
					} catch (NumberFormatException nfe) {
						id = id + "_1";
					}
				}
				return validateVariable(id);
			}
			return id;
		}

		public String getMappedClass(String objectType) {
			return this.classMap.get(objectType);
		}

		public void setKBase(KnowledgeBase kbase) {
			this.kBase = kbase;
		}

		public String getPackageName() {
			return packageName;
		}

		public void setPackageName(String pk) {
			this.packageName = pk;
		}

		public void mapClass(String name, String qName) {
			this.classMap.put(name, qName);

		}

		public String getVarType(String varS) {

			return variables.get(varS);
		}

		public void addVariable(String id, String type) {
			variables.put(id, type);
		}

		public Set<String> getVariables() {
			return variables.keySet();
		}

		public boolean isVariable(String id) {
			return variables.containsKey(id);
		}

		public String contextualizeVar(String id) {
			for (String varId : variables.keySet())
				if (varId.startsWith(this.getRuleName()) && varId.endsWith(id))
					return varId;
			return "";
		}

		/**
		 * @param currentElement
		 *            the currentElement to set
		 */
		public Element setCurrentElement(Element currentElement) {
			Element ans = this.currentElement;
			this.currentElement = currentElement;
			return ans;
		}

		/**
		 * @return the currentElement
		 */
		public Element getCurrentElement() {
			return currentElement;
		}

		/**
		 * @param ruleName
		 *            the ruleName to set
		 */
		private void setRuleName(String ruleName) {

			this.variables.clear();

			this.ruleName = ruleName;
		}

		/**
		 * @return the ruleName
		 */
		public String getRuleName() {
			return ruleName;
		}

		/**
		 * @param className
		 *            the className to set
		 */
		public void setClassType(String className) {
			this.classType = className;
		}

		/**
		 * @return the className
		 */
		public String getClassType() {
			return classType;
		}

		/**
		 * @param currentObjectVariable
		 *            the currentObjectVariable to set
		 */
		public String trySetCurrentObjectVariable(String currentObjectVariable) {
			String name = validateVariable(currentObjectVariable);
			this.currentObjectVariable = name;

			addVariable(this.currentObjectVariable, this.classMap.get(this
					.getClassType()));
			return name;
		}

		/**
		 * @return the currentObjectVariable
		 */
		public String getCurrentObjectVariable() {
			return currentObjectVariable;
		}

		/**
		 * @param currentField
		 *            the currentField to set
		 */
		public void setCurrentField(String currentField) {
			this.currentField = currentField;
		}

		/**
		 * @return the currentField
		 */
		public String getCurrentField() {
			return currentField;
		}

		/**
		 * @param currentFieldVariable
		 *            the currentFieldVariable to set
		 */
		public String trySetCurrentFieldVariable(String currentFieldVariable) {
			if (currentFieldVariable == null) {
				
				this.currentFieldVariable = null;
				return null;
				
			} else {
			
				this.currentFieldVariable = validateVariable(currentFieldVariable);

				addVariable(this.currentFieldVariable, reflect(getCurrentField(),
						this.classMap.get(this.getClassType())));

				return getCurrentFieldVariable();
			}
		}

		private String reflect(String fldName, String clazz) {
			try {
				String getterName = "get"
						+ fldName.substring(0, 1).toUpperCase()
						+ fldName.substring(1);

				Class klass = null;
				try {
					klass = Class.forName(clazz);
				} catch (ClassNotFoundException cnfe) {
					int j = clazz.lastIndexOf('.');
					klass = kBase.getFactType(clazz.substring(0, j),
							clazz.substring(j + 1)).getFactClass();
				}

				Method getter = klass.getMethod(getterName);

				return getter.getReturnType().getName();

			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}

		/**
		 * @return the currentFieldVariable
		 */
		public String getCurrentFieldVariable() {
			return currentFieldVariable;
		}

		public Element appendChild(Element el) {
			return (Element) this.getCurrentElement().appendChild(el);
		}

	}

}
