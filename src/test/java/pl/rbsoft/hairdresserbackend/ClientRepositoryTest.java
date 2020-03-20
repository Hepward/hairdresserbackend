/*
 * This code is unpublished proprietary trade secret of
 * Visiona Sp. z o.o., ul. Życzkowskiego 14, 31-864 Kraków, Poland.
 *
 * This code is protected under Act on Copyright and Related Rights
 * and may be used only under the terms of license granted by
 * Visiona Sp. z o.o., ul. Życzkowskiego 14, 31-864 Kraków, Poland.
 *
 * Above notice must be preserved in all copies of this code.
 */

package pl.rbsoft.hairdresserbackend;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.rbsoft.hairdresserbackend.domain.Client;
import pl.rbsoft.hairdresserbackend.domain.Visit;
import pl.rbsoft.hairdresserbackend.infrastructure.mongodb.ClientRepository;
import pl.rbsoft.hairdresserbackend.infrastructure.mongodb.VisitRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

//    @Autowired
//    private HistoryRepository historyRepository;

    @Autowired
    private VisitRepository visitRepository;

    @Before
    public void init() {
        clientRepository.deleteAll();
        visitRepository.deleteAll();
    }


    @Test
    public void createClientAddVisit() {
        Client client = new Client();
        client.setFirstname("Robert");
        client.setLastname("Ber");

        clientRepository.save(client);

        Optional<Client> byId = clientRepository.findById(client.getId());

        Visit visit = new Visit();
        visit.setClient(byId.get());
        visit.setDetails("farbowanie");
        visit.setVisitDate(LocalDateTime.now());

        byId.get().getVisits().add(visit);
        clientRepository.save(byId.get());
//        visitRepository.save(visit);

        Optional<Visit> byId1 = visitRepository.findById(visit.getId());

        Assert.assertEquals(byId.get().getId(), byId1.get().getClient().getId());
    }

    @Test
    public void visitsQuerying() {
        Visit visit1 = new Visit();
        visit1.setDetails("a");
        visit1.setVisitDate(LocalDateTime.of(2020, 02, 01, 9,55));

        Visit visit2 = new Visit();
        visit2.setDetails("a2");
        visit2.setVisitDate(LocalDateTime.of(2020, 02, 18, 15,55));

        Visit visit3 = new Visit();
        visit3.setDetails("a3");
        visit3.setVisitDate(LocalDateTime.of(2020, 02, 21, 15,55));

        Visit visit4 = new Visit();
        visit4.setDetails("a4");
        visit4.setVisitDate(LocalDateTime.of(2020, 03, 02, 15,55));

        visitRepository.saveAll(Arrays.asList(visit1,visit2,visit3,visit4));

        LocalDateTime febuaryBegin = LocalDateTime.of(2020, 02, 01, 0,00);
        LocalDateTime febuaryEnd = LocalDateTime.of(2020, 02, 29, 23,59);

        List<Visit> allByVisitDateBetween = visitRepository.findAllByVisitDateBetween(febuaryBegin, febuaryEnd);

        Assert.assertEquals(3, allByVisitDateBetween.size());
    }




//    @Test
//    public void createClientWithHistoryPoint_crateVisit_checkVisitClient(){
//        Client client = new Client();
//        client.setFirstname("Robert");
//        client.setLastname("Ber");
//
//        clientRepository.save(client);
//
//        String id = client.getId();
//
//        Client fetchedFromDb = clientRepository.findClientByFirstnameAndLastname(client.getFirstname(), client.getLastname()).get();
//        Assert.assertEquals(client, fetchedFromDb);
//
//        BaseVisit point = new BaseVisit();
//        point.setHistoryInfo("INF");
//        point.setEventDate(LocalDateTime.now());
//        fetchedFromDb.getHistoricalVisits().add(point);
//
//        clientRepository.save(fetchedFromDb);
//
//        fetchedFromDb = clientRepository.findClientByFirstnameAndLastname(client.getFirstname(), client.getLastname()).get();
//
//        Assert.assertEquals(point, fetchedFromDb.getHistoricalVisits().get(0));
//        Assert.assertEquals(id, fetchedFromDb.getId());
//
//
//    }

}
