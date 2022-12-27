package br.com.rachid.microservice_api_rachid

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.client.discovery.EnableDiscoveryClient


@SpringBootApplication
@EnableCaching
@EnableDiscoveryClient
class MicroserviceApiRachidApplication

fun main(args: Array<String>) {
    runApplication<MicroserviceApiRachidApplication>(*args)
}


