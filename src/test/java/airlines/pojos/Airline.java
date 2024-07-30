package airlines.pojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import utils.DateUtils;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Airline {

    private String id= RandomDataGenerator.getRandomNumber(10);
    private String name =RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME);
    private String country =RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.COUNTRY);
    private String logo=RandomDataGenerator.getRandomAlphabets(25);
    private String slogan=RandomDataGenerator.getRandomAlphabets(20);
    private String head_quaters=RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CITYNAME);
    private String website =  RandomDataGenerator.getRandomWebsiteName();
    private int established = RandomDataGenerator.getRandomNumber(1900, DateUtils.getCurrentyear());

}
