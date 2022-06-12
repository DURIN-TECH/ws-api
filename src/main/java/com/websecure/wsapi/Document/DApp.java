package com.websecure.wsapi.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(collection = "DAppList")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DApp {
    @Id
    private BigInteger id;

    private String name;
    @Indexed(unique = true)
    private String url;
    private String discord;
    private String twitter;
    private String cmc;
    private String cgc;
}
