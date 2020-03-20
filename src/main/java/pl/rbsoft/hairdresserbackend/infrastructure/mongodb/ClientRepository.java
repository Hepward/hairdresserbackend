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

package pl.rbsoft.hairdresserbackend.infrastructure.mongodb;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import pl.rbsoft.hairdresserbackend.domain.Client;


public interface ClientRepository extends MongoRepository<Client, String> {

    Optional<Client> findClientByFirstnameAndLastname(@Param("firstname") String firstname, @Param("lastname") String lastname);

}
