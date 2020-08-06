#!/bin/bash

. ./function/docker_function.sh

stop_rm_container 'myfront'
stop_rm_container 'myback'