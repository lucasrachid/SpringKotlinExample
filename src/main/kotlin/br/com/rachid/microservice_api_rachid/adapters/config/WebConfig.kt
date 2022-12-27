package br.com.rachid.microservice_api_rachid.adapters.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.codec.ClientCodecConfigurer
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.ResourceHttpMessageConverter
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter


@Configuration
class WebConfig : WebMvcConfigurer {

    val dateTimeFormat = "yyyy-MM-dd HH:mm:ss"
    val dateFormat = "yyyy-MM-dd"

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
    }

    override fun addInterceptors(registry: InterceptorRegistry) {

    }

    @Bean
    fun objectMapper(): ObjectMapper {
        return Jackson2ObjectMapperBuilder()
            .indentOutput(true)
            .dateFormat(SimpleDateFormat(dateFormat))
            .propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
            .serializers(LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)))
            .serializers(LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)))
            .build()
    }

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        converters.add(MappingJackson2HttpMessageConverter(objectMapper()))
        converters.add(ResourceHttpMessageConverter())
    }

    @Bean
    fun webClient(): WebClient? {
        val size = 16 * 1024 * 1024
        val strategies = ExchangeStrategies.builder()
            .codecs { codecs: ClientCodecConfigurer ->
                codecs.defaultCodecs().maxInMemorySize(size)
            }
            .build()
        return WebClient.builder()
            .exchangeStrategies(strategies)
            .build()
    }
}
