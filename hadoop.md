Hadoop--
(Slave node)Data node-Data is physicall store is called, it only knows block is responsible to store data
(Master node)Name node-Name node is reponsible for files which was stored in data nodes in form of blocks as well knows location of data
 name node doesnot know about block location

hadoop has set up config files which are responsible for data node to know about name node
under etc/hadoop/config
core-site.xml
hdfs-site.xml
master--> it contains information of secondary name nodes
slaves-->data node list

Racks-->collections on node
cluster-->racks inteconnected over n/w

Name node contains FSIIMage file in disk suppose in case of failure it replicate itself into another name node so that single point of
faliure will not occure

for FSIIMAGE slownew we keeps edits file in b/w name node and fsiismage so that any current opration write on it when completed store into
fsiimage but it has its own disagvantages

so Secondary Namenode comes in picture

secondary namenode merged all edits files  then merged with fsimage file and finally provide new fsimage file to Primary Nmanode

Secondary namenode not a backup node

recent updates always done in primary nodes

improvemnet in hadoop--
2 new node concepts comes in picture
1-checkpoint node
2-backup node

Now secondary name node deprecated now new concept of checkpoints nodes comes in picture
Backupnodes -- receive live streams of edits file changes
keep fsimage in memory now merging very faster and efficent

backup replaces checkpoint node and secondary name node


HA configures
 for this we need two node
 primary name node and standby name node
 now edit files in shared dir so that both can check from this


nod name -->job tracker
nod name--> task tracker(data node or name node)


In mrv2 or yarn job tracker replace with resource manager node and
task tracker replacew with node manager
resource manager
  |
application manger
  |
node manager


for resource magnager info
yarn-site.xml


hadoop cluster setup-


In ECW EMR is use for running map reduce jobs among different computer
managed hadoop framwork(EMR)


3 linux setup
first setup name node and resource manager on same machine

Cloudarea manager


Flume component :
(logfile or any jms source)source -->channel -->sink-->hdfs


sink -->define destination
channel -->is buffer reponsible for not loose data

1 source pushing to 2 diiferent sink(called replicatoin)


Multiple flume Agent-
called replication


Kafka source-
Key concept
Arch.
tolarance of failure
RSVP consume
then kafka connect



needs of zookeper

100,000 per seoncd message process


PLACES   MESSAGE IN topics

Kafka cluster place in zookper cluster

Multinode kafka cluster

Problem wiht mutinode cluster
only one broker peeking another are resting
Solution --> needs of partition
suppose partition in only partition in single node it increase peeking so needs of multiple partitioning


so now needs to create consumer group and create a relationship among them so same message cannot duplicate ,now associate consumer to
consumer group

now consumer also have partition

so now needs of logic in partitioning so that producer cluster read message and

every Node retains data of 7days

Replication in synch-
so now concept of leader and followers come in picture

replica.log.time.max.ms=10(it means followers synch after every 10 seco)

In sych replica(ISR)

so needs of mininsycn replaica more the 1
unclean.leader.electoin.enable=true(by default true needs to true so insych concpet works)
min.insync.replicas=2



zookeper is reponsible for managing nodes in cluster


suppose we nedds distrubutions of message so we needs partiiontiong more ON topics


Pig -
Load data:
store any type of schema data
no need to define any data type or schme it's up to you

interanlly it uses mapreduce for execution of jobs


Data type:
Tuple==>()==>collection of rows
Bag==>{}-->collection of tuple==>more like a table
Map==>[]==>key and value seprated by # and each key value pair seprted by commo

Cogroup --> no needs of join key word

PageRank--




Hive:: facebook develop it
like sql query analysis

convert data into map reduce

pig used -->ETL type of job like clean up and other filtering and extra
hive-->for data analysis
.

no point of deletion and uppdatation
batch processing tools which running mr jobs behind the scenes
limitation support of indexing ,triggers and limitaion support of transaction

join is same as sql
efficent to structure data in partition and bucket
does not care about of strcture of data
must known tools

Serde--> serialize data and deserilize data


Two tables in hive:
Manage table-- we can delete data inside it
External table-- we cannt delte data inside it , used when multiple source uses same data storage

when running order by only 1 reducer create needs to custom it and
will used sort by instead of order by

but in this case suppose we have symbol and year we sort by symbol so what happens
files are create different but symbols are repeated for this shortcoming
we use distrubute by key

IF WE have same set of columns and we used sort by and distrubte by then you can replace clusterby


Partitioning:
Optimizing quering running fast in such case required partiting

dynamic partition enable by default it is strict


Buckets::
partition by (exe_nam string,yr string)
cluster by (symbol) into 5 buckets

struct data types in hyve like struct in c or objects in java
shadea is reponsible for parsing and sturcture of json data

Map:



compression algos:
gzip
snappy
LZO
etc


-Gzip not directly not supporting spliting
-Sequence File-

If we want to store files as it is.

