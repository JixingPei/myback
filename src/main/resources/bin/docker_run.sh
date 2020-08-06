#!/bin/bash

. ./function/docker_function.sh

#my back
if [ -d '/opt/myphoto/myback/' ]; then
    mkdir -p '/opt/myphoto/myback/'
fi
DOCKER_CONTAINER_NAME_BACK='myback'
VOLUME_BACK='-v /opt/myphoto/myback/:/opt/myphoto/myback/'
DOCKER_IMAGE_BACK='myback'
PORT_BACK='9999:8888'
$(run_docker_run ${DOCKER_CONTAINER_NAME_BACK} ${VOLUME_BACK} ${DOCKER_IMAGE_BACK} ${PORT_BACK})


#my frot
DOCKER_CONTAINER_NAME_FRONT='myfront'
VOLUME_FRONT='-v /opt/myphoto/myfront/:/opt/myphoto/myfront/'
DOCKER_IMAGE_FRONT='myfront'
PORT_FRONT='80:9528'
$(run_docker_run ${DOCKER_CONTAINER_NAME_FRONT} ${VOLUME_FRONT} ${DOCKER_IMAGE_FRONT} ${PORT_FRONT})