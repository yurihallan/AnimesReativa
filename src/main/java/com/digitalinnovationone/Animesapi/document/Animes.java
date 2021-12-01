package com.digitalinnovationone.Animesapi.document;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "Animes_Api_Table")
public class Animes {
    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;
    @DynamoDBAttribute(attributeName = "name")
    private String name;
    @DynamoDBAttribute(attributeName = "tipo")
    private String tipo;
    @DynamoDBAttribute(attributeName = "manga")
    private int manga;

    public Animes(String id, String name, String tipo, int manga) {
        this.id = id;
        this.name = name;
        this.tipo = tipo;
        this.manga = manga;
    }
}
