package org.drools.lang;

//import org.drools.RuntimeDroolsException;
//import org.drools.base.evaluators.Operator;

/**
 * Simple holder class identifying all the DRL soft keywords. This is used by
 * DRLParser.
 * 
 * @author porcelli
 */
public class DroolsSoftKeywords { 

	public static final String A_ACTGROUP = "activation-group"; 
	public static final String A_AGENDAGROUP = "agenda-group"; 
	public static final String A_AUTOFOCUS = "auto-focus"; 
	public static final String A_CALENDAR = "calendar"; 
	public static final String A_DATE_EFFECTIVE = "effective"; 
	public static final String A_DATE_EXPIRES = "expires"; 
	public static final String A_DEDUCTION = "deduction"; 
	public static final String A_DIALECT = "dialect"; 
	public static final String A_DIRECTION_ABDUCTIVE = "abductive"; 
	public static final String A_DIRECTION_DEDUCTIVE = "deductive"; 
	public static final String A_DIRECTION_EQUIVALENCE = "equivalence"; 
	public static final String A_DURATION = "duration"; 
	public static final String A_ENABLED = "enabled"; 
	public static final String A_IMPLICATION = "implication"; 
	public static final String A_LOCKONACTIVE = "lock-on-active"; 
	public static final String A_NOLOOP = "no-loop"; 
	public static final String A_RULEFLOWGROUP = "ruleflow-group"; 
	public static final String A_SALIENCE = "salience"; 
	public static final String A_TIMER = "timer"; 
	public static final String ACC = "acc"; 
	public static final String ACCL = "accL"; 
	public static final String ACCUMULATE = "accumulate"; 
	public static final String ACCUMULATE_RIGHT = "accR"; 
	public static final String ACTION = "action"; 
	public static final String ACTIVATION = "activation"; 
	public static final String ACTIVE = "active"; 
	public static final String AGENDA = "agenda"; 
	public static final String ALL = "all"; 
	public static final String AND = "and"; 
	public static final String ANNOTATIONS = "annotations"; 
	public static final String ANOTHER = "another";
	public static final String AS = "as"; 
	public static final String ATTRIBUTES = "attributes"; 
	public static final String AUTO = "auto"; 
	public static final String AVERAGE = "avg"; 
	public static final String BOOL = "true"; 
	public static final String BOOLEAN = "boolean"; 
	public static final String BRANCH = "branch"; 
	public static final String BYTE = "byte"; 
	public static final String CALENDARS = "calendars"; 
	public static final String CHAR = "char"; 
	public static final String CHARACTERISTICS = "Characteristics"; 
	public static final String CLASS = "Class"; 
	public static final String CLOSURE = "closure"; 
	public static final String COLLECT = "collect"; 
	public static final String COLLECT_LIST = "collectList"; 
	public static final String CONTAINS = "contains"; 
	public static final String COUNT = "count"; 
	public static final String DATATYPE = "Datatype"; 
	public static final String DATE = "date"; 
	public static final String DECLARE = "declare"; 
	public static final String DEFEATS = "defeats"; 
	public static final String DIFFERENT_INDIVIDUALS = "differentIndividuals"; 
	public static final String DIFFERENTFROM = "differentFrom"; 
	public static final String DISJOINT = "disjointWith"; 
	public static final String DISJOINT_CLASSES = "disjointClasses"; 
	public static final String DISJOINT_PROPERTIES = "disjointProperties"; 
	public static final String DISJOINT_UNION = "disjointUnionOf"; 
	public static final String DISTINCT = "distinct"; 
	public static final String DO = "do"; 
	public static final String DOMAIN = "domain"; 
	public static final String DOUBLE = "double"; 
	public static final String DURATION = "duration"; 
	public static final String EFFECTIVE = "effective"; 
	public static final String ENABLED = "enabled"; 
	public static final String END = "end"; 
	public static final String ENTITY = "Entity"; 
	public static final String ENTRY = "entry"; 
	public static final String ENTRYPOINT = "entry-point"; 
	public static final String EQUIV = "equiv"; 
	public static final String EQUIVALENT_CLASSES = "equivalentClasses"; 
	public static final String EQUIVALENT_PROPERTIES = "equivalentProperties"; 
	public static final String EQUIVALENTTO = "equivalentTo"; 
	public static final String EVAL = "eval"; 
	public static final String EVENT = "Event"; 
	public static final String EXACTLY = "exactly"; 
	public static final String EXCLUDES = "excludes"; 
	public static final String EXISTS = "exists"; 
	public static final String EXPIRES = "expires"; 
	public static final String EXTEND = "extends"; 
	public static final String EXTENDS = "extends"; 
	public static final String FACTS = "facts"; 
	public static final String FALLING = "falling"; 
	public static final String FILTER = "filter"; 
	public static final String FLOAT = "float"; 
	public static final String FOCUS = "focus"; 
	public static final String FORALL = "forall"; 
	public static final String FROM = "from"; 
	public static final String FUNCTION = "function"; 
	public static final String GLOBAL = "global"; 
	public static final String GROUP = "group"; 
	public static final String HASKEY = "HasKey"; 
	public static final String IMPLIES = "implies"; 
	public static final String IMPORT = "import"; 
	public static final String IN = "in"; 
	public static final String INDIVIDUAL = "individual"; 
	public static final String INIT = "init"; 
	public static final String INSERT = "insert"; 
	public static final String INSERT_LOG = "insertLogical"; 
	public static final String INSTANCEOF = "instanceof"; 
	public static final String INT = "int"; 
	public static final String INVERSE = "inverse"; 
	public static final String INVERSEOF = "inverseOf"; 
	public static final String JAVA = "java"; 
	public static final String KEY = "key"; 
	public static final String LENGTH = "length"; 
	public static final String LENGTH_MAX = "maxLength"; 
	public static final String LENGTH_MIN = "minLength"; 
	public static final String LIMIT = "limit"; 
	public static final String LOCK = "lock"; 
	public static final String LONG = "long"; 
	public static final String LOOP = "loop"; 
	public static final String MATCHES = "matches"; 
	public static final String MAX = "max"; 
	public static final String MDA_FUNCTIONAL = "functional"; 
	public static final String MDA_FUNCTIONAL_INV = "inverseFunctional"; 
	public static final String MDA_REFLEXIVE = "reflexive"; 
	public static final String MDA_REFLEXIVE_INV = "irreflexive"; 
	public static final String MDA_SYMMETRIC = "symmetric"; 
	public static final String MDA_SYMMETRIC_INV = "asymmetric"; 
	public static final String MDA_TRANSITIVE = "transitive"; 
	public static final String MEMBEROF = "memberof"; 
	public static final String MIN = "min"; 
	public static final String MODIFY = "modify"; 
	public static final String MODIFY_LOG = "modifyLogical"; 
	public static final String MOL = "mol"; 
	public static final String MVEL = "mvel"; 
	public static final String NAMESPACE = "namespace"; 
	public static final String NEG = "neg"; 
	public static final String NEW = "new"; 
	public static final String NO = "no"; 
	public static final String NOT = "not"; 
	public static final String NULL = "null"; 
	public static final String OA_CRISP = "crisp"; 
	public static final String OA_DEFAULT = "default"; 
	public static final String OA_DEFEAT = "defeat"; 
	public static final String OA_DEGREE = "degree"; 
	public static final String OA_ID = "id"; 
	public static final String OA_KIND = "kind"; 
	public static final String OA_MERGE = "merge"; 
	public static final String OA_MISSING = "missing"; 
	public static final String OA_OTHERWISE = "otherwise"; 
	public static final String OA_PARAMS = "params"; 
	public static final String ON = "on"; 
	public static final String ONCHANGE = "onChange"; 
	public static final String ONLY = "only"; 
	public static final String ONTOLOGY = "ontology"; 
	public static final String OR = "or"; 
	public static final String ORDERBY = "orderby"; 
	public static final String OTHERWISE = "OTHERWISE"; 
	public static final String OVER = "over"; 
	public static final String PACKAGE = "package"; 
	public static final String PATTERN = "pattern"; 
	public static final String PATTERN_LANG = "langPattern"; 
	public static final String POINT = "point"; 
	public static final String PREFIX = "Prefix"; 
	public static final String PROPERTY = "property"; 
	public static final String PROPERTY_ANNOTATION = "AnnotationProperty"; 
	public static final String PROPERTY_DATA = "DataProperty"; 
	public static final String PROPERTY_OBJECT = "ObjectProperty"; 
	public static final String QUERY = "query"; 
	public static final String RANGE = "range"; 
	public static final String RESULT = "result"; 
	public static final String RETRACT = "retract"; 
	public static final String RETRACT_LOG = "retractLogical"; 
	public static final String REVERSE = "reverse"; 
	public static final String RISING = "rising"; 
	public static final String ROLE = "role"; 
	public static final String RULE = "rule"; 
	public static final String RULEFLOW = "ruleflow"; 
	public static final String SALIENCE = "salience"; 
	public static final String SAME_INDIVIDUAL = "sameIndividual"; 
	public static final String SAMEAS = "sameAs"; 
	public static final String SELF = "Self"; 
	public static final String SEQ = "seq"; 
	public static final String SHORT = "short"; 
	public static final String SOME = "some"; 
	public static final String SOUNDSLIKE = "soundslike"; 
	public static final String START = "start"; 
	public static final String SUBCLASSOF = "SubClassOf"; 
	public static final String SUBPROPERTYCHAIN = "SubPropertyChain"; 
	public static final String SUBPROPERTYOF = "SubPropertyOf"; 
	public static final String SUM = "sum"; 
	public static final String SUPER = "super"; 
	public static final String TEMPLATE = "template"; 
	public static final String THAT = "that"; 
	public static final String THEN = "then"; 
	public static final String THIS = "this"; 
	public static final String THROTTLE = "throttle"; 
	public static final String TIME = "time"; 
	public static final String TIMER = "timer"; 
	public static final String TYPE = "type"; 
	public static final String TYPE_BOOLEAN = "boolean"; 
	public static final String TYPE_DOUBLE = "double"; 
	public static final String TYPE_FLOAT = "float"; 
	public static final String TYPE_INTEGER = "integer"; 
	public static final String TYPE_STRING = "string"; 
	public static final String TYPES = "types"; 
	public static final String UNIQUE = "unique"; 
	public static final String UPDATE = "update"; 
	public static final String VALUE = "value"; 
	public static final String VERY = "very"; 
	public static final String VOID = "void"; 
	public static final String WHEN = "when"; 
	public static final String WINDOW = "window"; 
	public static final String XOR = "xor";
	
	public static final String CASE = "case";
	public static final String FINAL = "final";
	public static final String IF = "if";
	public static final String ELSE = "else";
	public static final String FOR = "for";
	public static final String WHILE = "while";
	public static final String IMPLEMENTS = "implements";
	public static final String DEFAULT = "default";
	public static final String TRY = "try";
	public static final String CATCH = "catch";
	public static final String FINALLY = "finally";
	public static final String SWITCH = "switch";
	public static final String SYNCHRONIZED = "synchronized";
	public static final String RETURN = "return";
	public static final String THROW = "throw";
	public static final String BREAK = "break";
	public static final String CONTINUE = "continue";
	public static final String ASSERT = "assert";
	public static final String STATIC = "static";
	  
	public static final String PUBLIC = "public";
	public static final String PROTECTED = "protected";
	public static final String PRIVATE = "private";
	public static final String ABSTRACT = "abstract";
	public static final String NATIVE = "native";
	public static final String TRANSIENT = "transient";
	public static final String VOLATILE = "volatile";
	public static final String STRICTFP = "strictfp";
	public static final String THROWS = "throws";
	public static final String INTERFACE = "interface";
	public static final String ENUM = "enum";	
	public static final String DIALECT = "dialect";
	
    
	
	

	public static boolean isOperator( final String operator, final boolean negated ) { 
		try {
			// Operator.determineOperator( operator, negated );
			return true;
		} catch( RuntimeException rde ) { 
			return false;
		}
	}





}
