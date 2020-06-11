Docker plugin
build=>ship=>run

ran app in distribution env.

running image is called ==>docker container

running image+==>running multiple container

delivery tech
build ->docker image
ship ->docker hub registry
run -> docker container

PODA==> package once deploy anywhere



docker relies on minimial os system

docker-machine --> cli of docker

docker-compose--> fro mulitcontainer


copy ==>copy file or dir into container
add ==> same as copy but auto extration of tar files as well

run ==>running scrips or installing soft.
cmd ==> default command exe. container

ENTRYPOINT ["/entrypoint.sh"]

publishing certian point so we needs to expose port
EXPOSE 9090  publish host port

VOLUME -> create a mount point
docker container run ... -v ~/data:/opt/var (host:container )


USER
HEALTHCHECK


io.fabric8 maven plugin


craete own tag and share among alls


docker image build -t helloworld
docker container run helloworld:latest
docker container run repository:tag

tagging to latest===
docker image tag helloworld:1
docker image tag helloworld:1 helloworld:latest

docker compose
run multicontainer application very easily
congituraiton define in multiple files or same file

docker-compose.yml  (default)
docker-compose.override.yml(default)

docker file using -f ==>multple file using -f

extending services

run--
docker-compose \ -f docker-compose.yml \ -f docker-compse.db.yml \ up -d

service--
docker-compose \ -f docker-compose.yml \ -f docker-compse.db.yml \ ps


extends using extends: clause use
 docker-compose --verbose up -d


================================================================================
docker swarm:: new featrure 1.12
natively manage cluster of docker engine called swarm
docker cli to create a swarn deploye setup etc , needs to explicity enable
no single point of failure

declarative state model

self organizing and self healing
service discovery ,load balancing ,and scaling
rolling updates

swarn manager --> odd number of manager

================================================================================
--mode=global  ->single service deployed in  multiple hosts

plugin:
portworx


monitor docker::
docker container stats cli
docker remote api
docker system event apis

another apis(third apis)
1:prometheus
2:cadivisor


minikube-->single cluster inside a vm
docker desktop--


