package com.websecure.wsapi.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({ "id", "discord", "twitter", "cmc", "cgk", "rank", "about" })
public class Dapp {
    @Id
    private String id;

    private String name;
    private String url;
    private String discord;
    private String twitter;
    private String cmc;
    private String cgk;
    private String rank;
    private String about;

}
