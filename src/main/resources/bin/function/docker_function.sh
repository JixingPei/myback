#!/bin/bash

#固定値取得方法
function get_prop_from_config() {
    # 想要取得的内容=$1
    # 文件=$2
    grep "^${1}=" ${2} | cut -d"=" -f2 | sed "s/\r//"
}

LOCALHOST_IP=$(hostname | xargs ping -c 1 -w 1 | sed '1{s/[^(]*(//;s/).*//;q}')
STATUS_ACTIVE='ACTIVE'
STATUS_STOP='STOP'
NOT_EXIST_CONTAINER='NOT_EXIST'
#docker build（创建docker image）
function run_docker_build() {
    # DOCKER_FILE=$1
    # DOCKER_NAME=$2
    # DOCKER_TAG=$3
    docker build -f ${1} -t ${2}:${3}
}

#docker build（创建docker container)
function run_docker_run() {
    #DOCKER_CONTAINER_NAME = $1
    #VOLUME = $2
    #DOCKER_IMAGE = $3
    #PORT = $4
    docker run -dit -p ${4} --name="${1}" "${2}" "${3}" >/dev/null
}

#获取container的状态
function get_container_status() {
    IP=${1}
    DOCKER_CONTAINER_NAME=${2}
    if [[ ${IP} != ${LOCALHOST_IP} ]]; then
        ssh -o StrictHostKeyChecking=no -tt ${IP} docker ps -f name="${DOCKER_CONTAINER_NAME}" -q | grep -q . && echo "${STATUS_ACTIVE}"
    else
        docker ps -f name="${DOCKER_CONTAINER_NAME}" -q | grep -q . && echo "${STATUS_ACTIVE}" && return
        docker ps -a -f name="${DOCKER_CONTAINER_NAME}" -q | grep -q . && echo "${STATUS_STOP}" || echo "${NOT_EXIST_CONTAINER}"
    fi
}

function stop_rm_container() {
    stop_container "${1}"
    rm_container "${1}"
}


#container停止
function stop_container() {
    #DOCKER_CONTAINER_NAME=${1}
    docker stop ${1} >/dev/null
}

#container删除
function rm_container() {
    #DOCKER_CONTAINER_NAME=${1}
    docker rm ${1} >/dev/null
}
