package org.stone.thiagovb62.Config;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DockerClientConfig {

    @Value("${docker.socket.path}")
    private String dockerSocketPath;

    @Bean
    public DockerClient dockerClient() {
        DefaultDockerClientConfig.Builder configBuilder = DefaultDockerClientConfig.createDefaultConfigBuilder();


        if(this.dockerSocketPath != null && !this.dockerSocketPath.startsWith("unix://")) {
            configBuilder.withDockerHost(dockerSocketPath).
           withDockerTlsVerify(false);
        }

        DefaultDockerClientConfig config = configBuilder.build();

        ApacheDockerHttpClient httpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(config.getDockerHost())
                .build();

        return DockerClientBuilder.getInstance(config)
                .withDockerHttpClient(httpClient)
                .build();
    }
}
