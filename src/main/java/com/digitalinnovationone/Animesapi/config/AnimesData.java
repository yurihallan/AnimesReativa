package com.digitalinnovationone.Animesapi.config;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.digitalinnovationone.Animesapi.constans.AnimesConstant.ENDPOINT_DYNAMO;
import static com.digitalinnovationone.Animesapi.constans.AnimesConstant.REGION_DYNAMO;

public class AnimesData {

    public static void main(String[] args) throws Exception {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);


        Table table = dynamoDB.getTable("Animes_Table");
        Item anime = new Item()
                .withPrimaryKey("id",1)
                .withString("name", "One Piece")
                .withString("tipo","Aventura/Luta")
                .withNumber("manga", 1000);

        PutItemOutcome outcome = table.putItem(anime);

    }
}
