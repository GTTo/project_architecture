database:
	@echo Create Database
	docker exec -ti mysql sh -c "mysql -uroot -proot < /opt/bd/01-database.sql"

build-images:
	@echo Build Images.
	mvn spring-boot:build-image -f ../eureka_server/pom.xml
	mvn spring-boot:build-image -f ../config_server/pom.xml

docker-up:
	@echo Docker-compose up
	docker-compose up

docker-delete:
	@echo Docker Delete all
	docker volume prune
	docker system prune -a

api-gateway:	
	mvn spring-boot:run -f ../api_gateway/pom.xml