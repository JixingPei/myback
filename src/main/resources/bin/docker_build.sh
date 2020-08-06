#!/bin/bash

. ./function/docker_function.sh


#myback
$(run_docker_build './dockerFiles/Dockerfile_back' 'myback' '0.0.1' ) 
#myfront
$(run_docker_build './dockerFiles/Dockerfile_front' 'myfront' '0.0.1' ) 