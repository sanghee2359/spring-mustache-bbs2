# Build N Run Container with DB Container
# 2020. 09. 18 Zini

### You MUST RUN Docker Container First ###
SPRING_DATASOURCE_URL=""
SPRING_DATASOURCE_PASSWORD=""
project_name="spring-mustache-bbs2"
container_id=""
image_name="spring-mustache-bbs"
host_port=8080
virtual_port=8080

echo "## Automation docker build and run ##"

# remove container
echo "=> Stop previous container..."
docker stop ${container_id}

# move image
echo "=> Remove previous image..."
cd ${project_name}

# git pull
git pull

# new-build/re-build docker image
echo "=> Build new image..."
docker build -t ${image_name} .

# Run container connected to existing docker container
echo "=> Run container..."
docker run -p ${host_port}:${virtual_port} -e SPRING_DATASOURCE_URL=jdbc:mysql://${SPRING_DATASOURCE_URL} -e SPRING_DATASOURCE_PASSWORD=${SPRING_DATASOURCE_PASSWORD} ${image_name}
