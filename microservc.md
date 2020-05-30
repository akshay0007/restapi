@EurakaServer
some props sets
like
regsitry-with-eurakclient=false
fetch-registry=false

@EurakaClient==no needs to define in all

in resttemplete bean just define @Loadbalancing -->so that it can do client discovery and load balancing
application-name used for ip+port

interface =>Discovery client gives all services in euraka server

Fault taularance=
heart beats also check for service alive

fault tolaance : tolarance of existing problem how it can handle
resiliant -- how many falut system can tolarate



time out : solves issue of slow services + needs thread limits


circut breaker params
last n request to consider
how many of those request got falied out of n
time out duration

when doese circut got norml
how long circuit to try again


fallback mach. when a circuit breaks
 saving pre. resoponse in cache
 fallback def. response
 throw a error (last point)


falilback fast
fallback func.
automatic recovery


@EnableCircuitBreaker
but not doing anything

for giving instruction

addd @HystrixCOmmand
l
configure hystrix paramertes
@HystrixCommand(fallbackMethod="getFallbackCatalog")

create method proxy method
getFallbackCatalog(){
//hard coded responses or cache of response
}

hystrix create proxy class and contains fallback machanism

@Hystrixcommand(fallback="getFallback",
commandProperties={
    @hystrixPropertie(name ="timeocut",value)
}
)


hystrix dashboard:
turbine for setup for hystix
@EnableHystrixDashboard

==================
bulkhead pattern::
@HystrixComman(
fallbackMethod=
threadPoolKey=
    threadPoolProperties={

    }
)


externialize::
enviroment specific(spring profile)

micro service ==

understanding of goals of microservice


centralizer server -->
zoopker
ETCD
harshicorp
spring cloud config server


with microservice we can configure props for different instance
like ec2 and db another source configuration and creaditials
feature flags also can put on it
featurre turn on off in server
business logic and configureation
scenerio testing
spring boot configureation

deploy in production so needs of push of prosp so that everything works fine commonly we can used
cicd configure

increase number of thrads and another configure so that no needs to deploy complete code into prod


differrent  types of configures files:: xml and props,yml,json

Goals::
 Exernilize all configure
 should be env specific
 consistent
 version history along with this
 real time mgt

using properties files in spring boot

props always inside jar suppose we want to change prosp then solution ::

first approach==
java -jar abc.jar

now creating props files in same dir
java -jar abc.jar


second approach ==
java -jar abc.jar --my.appname="hello world from cmd"

third approach===
system props


===========================================
three diffeernt ways of @Value injections
@Value("hele")
String name

@Value("${app.name:default value }")
String name

out put default value

my.list=one,two,thress

@Value("${my.list}")
List<String> lists

db.values={url:'url',username:'user',password:'pss'}


@Value("#{${db.values}}")
Map<String,String> dbmaps



pullups lots of values ::
db.url=
db.user=
db.pass=

@Configuration
@ConfigurationProperties(prefix="db")
class DBPors{
    String url;
    String user;
    String pass;
}


Spring boot actuator::
enable all points in local
management.endpoints.web.exposure.include=*

localhost:8080/actuator/configprops


YAML::

key:value

app:
    name:abc
    descirption: desc


spring profiles::

dev props
prod props

app.ext
spring.profile.active=test

app-profile.extension


can do more then one profile active at same time

java -jar abc.jar --spring.profile.active=test


selecting beans on the basis of profile


@Profile("dev")
class DbSourceLocal{

}

@Profile("prod")
class DbSource{

}


understanding env objects::

@Enviorment

@ReqpeustsMapping
publicv String getEnv(){
return env.getDefaultPorfiles();
}

env.getProperty("abc")


create seprate configure server for managing props.

config as a seprate microservice

configuration service as a seprate micorservice

better version repo system ::


adding cloud configure server

@EnableCOnfiugreserver
==> but doesnt knwo from where to pull ups values

propesrties -->
spring.cloud.config.server.git.uri=
run apps

then localhost:port/<filename>/<profile>
then localhost:port/application/default


spring boot config client
string-cloud-starter-config

define urls in props file::
spring.cloud.config.uri=url:port

now all files got from configure server related db props or all stuffs
so now we want configure from individual microservice related to port and urls

now all props cenralize and individuals prosps are overirde by existing server props


so now each artifactory or appnames are unique

 ================
now for solution we put file name with appname
suppose microservice A has name ==> a-myname
suppose microservice B has name ==> b-myname

now put a-myname.prooperties and b-myname.properties needs to create in git repo



whenever any updates happend in config server it will update in each microservice so we need refresh properties
so that each microservice has its own updated values
for that we need some thing else

for that we needs actuator dependency which is helpfull in endponint definition
one  of the end point responisble for updated values is ==================++++>hookup enpoint

=======================
so suppose we want some spring componet to refresh which were responsible for connnecting with config server
then put annoatition

@RefreshScope==================
refreshing  beans

========


==================== provided by actuator ======================
localhost:port/actuator/refresh
============================================================


