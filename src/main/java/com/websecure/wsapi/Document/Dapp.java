package com.websecure.wsapi.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DappList")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dapp {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;
    private String url;
    private String discord;
    private String twitter;
    private String cmc;
    private String cgk;

    public Dapp(String url){
        this.url = url;
    }
}
