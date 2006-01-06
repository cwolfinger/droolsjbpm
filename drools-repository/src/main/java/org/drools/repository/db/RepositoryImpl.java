package org.drools.repository.db;

import java.util.List;

import org.drools.repository.Repository;
import org.drools.repository.RuleDef;
import org.drools.repository.RuleSetAttachment;
import org.drools.repository.RuleSetDef;
import org.hibernate.Session;



public class RepositoryImpl implements Repository {

    /** This will simply save the current version of the rule */
    public RuleDef save(RuleDef newRule) {
        Session session = getSession();
        session.beginTransaction();

        session.saveOrUpdate(newRule);

        session.getTransaction().commit();
        
        return newRule;
    }
    

    
    //DODGY METHODS START
    public List listAllRules(boolean head) {
        Session session = getSession();
        session.beginTransaction();
        List results = session
                    .createQuery("from RuleDef where head = :head")
                    .setBoolean("head", head).setMaxResults(1000)
                    .list();        
        session.getTransaction().commit();
        return results;        
    }
    
    public RuleDef loadRule(String ruleName, long versionNumber) {
        Session session = getSession();
        session.beginTransaction();
        
        RuleDef result = (RuleDef) session.createQuery("from RuleDef where name = :name and versionNumber = :version")
              .setString("name", ruleName)
              .setLong("version", versionNumber).uniqueResult();
        
        session.getTransaction().commit();
        return result;
    }
    
    public List listRuleHistory(String ruleName) {
        Session session = getSession();
        session.beginTransaction();
        
        List result = (List) session.createQuery("from RuleDef where name = :name order by versionNumber")
              .setString("name", ruleName).list();
        
        session.getTransaction().commit();
        return result;        
    }
    //DODGY METHODS END
    
    public List findRulesByTag(String tag) {
        Session session = getSession();
        session.beginTransaction();
        List result = session.createQuery("from RuleDef as rule where rule.tags.tag = :tag")
            .setString("tag", tag)
            .list();              
        session.getTransaction().commit();
        return result;
    }
    

    
    public RuleSetDef save(RuleSetDef ruleSet) {
        Session session = getSession();
        session.beginTransaction();     
        session.saveOrUpdate(ruleSet);
        session.getTransaction().commit();
        return ruleSet;
    }
    
    public RuleSetDef loadRuleSet(String ruleSetName) {
        Session session = getSession();
        session.beginTransaction();        
        RuleSetDef def = (RuleSetDef)
                session.createQuery("from RuleSetDef where name = :name")
                .setString("name", ruleSetName ).uniqueResult();
        session.getTransaction().commit();
        return def;
    }
    
    public void save(RuleSetAttachment attachment) {
        Session session = getSession();
        session.beginTransaction();
        session.saveOrUpdate(attachment);
        session.getTransaction().commit();
    }
    
    public RuleSetAttachment loadAttachment(String name) {
        Session session = getSession();
        session.beginTransaction();
        RuleSetAttachment at = (RuleSetAttachment) 
                                session.createQuery("from RuleSetAttachment where name = :name")
                                .setString("name", name)
                                .uniqueResult();
        session.getTransaction().commit();
        return at;       
    }
    
    
    
    private Session getSession(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return session;
    }
    
    
}
