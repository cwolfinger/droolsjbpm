import org.rioproject.config.Constants
import java.util.logging.Level

import org.rioproject.resources.servicecore.Service
import org.rioproject.system.SystemWatchID

deployment(name:'executionNodeService',  debug: 'true') {

    //logging {
      //  logger 'org.rioproject.resolver', Level.FINEST
      //  logger 'org.rioproject.associations' , Level.FINEST
      //  logger 'org.rioproject.gnostic', Level.FINEST

    //}
    /* Configuration for the discovery group that the service should join.
     * This first checks if the org.rioproject.groups property is set, if not
     * the user name is used */
    groups System.getProperty(Constants.GROUPS_PROPERTY_NAME,
                              System.getProperty('user.name'))

    /* Declares the artifacts required for deployment. Note the 'dl'
     * classifier used for the 'download' jar */
    artifact id:'api', 'org.drools:drools-grid-distributed-api:5.2.0.SNAPSHOT'
    artifact id:'service', 'org.drools:drools-grid-distributed-rio:5.2.0.SNAPSHOT'
    artifact id:'service-dl', 'org.drools:drools-grid-distributed-rio:dl:5.2.0.SNAPSHOT'

    /*
     * Declare the service to be deployed. The number of instances deployed
     * defaults to 1. If you require > 1 instances change as needed
     */
    service(name: 'ExecutionNodeService', fork: 'no') { //fork yes, works only in unix machines
        interfaces {
            classes 'org.drools.grid.ExecutionNodeService'
            artifact ref:'service-dl'
        }
        implementation(class:'org.drools.grid.distributed.impl.ExecutionNodeServiceImpl') {
            artifact ref:'service'
        }

        maintain 2
    }


    rules {
        rule{
            resource 'SLAKsessions'
            ruleClassPath 'org.drools:drools-grid-distributed-rio:5.2.0.SNAPSHOT'
            serviceFeed(name: "ExecutionNodeService") {
                watches "ksessionCounter"
                //, ${SystemWatchID.SYSTEM_CPU}, ${SystemWatchID.JVM_MEMORY}"
            }
        }
    }


}