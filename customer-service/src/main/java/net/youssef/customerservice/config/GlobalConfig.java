package net.youssef.customerservice.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "global.params")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalConfig {
    private int p1;
    private int p2;
}
