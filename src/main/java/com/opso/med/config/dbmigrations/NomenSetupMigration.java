package com.opso.med.config.dbmigrations;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.opso.med.domain.Authority;
import com.opso.med.domain.Domain;
import com.opso.med.domain.User;
import com.opso.med.security.AuthoritiesConstants;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.ZonedDateTime;

/**
 * Creates the initial database setup
 */
@ChangeLog(order = "002")
public class NomenSetupMigration {

    @ChangeSet(order = "01", author = "initiator", id = "01-addDomains")
    public void addDomains(MongoTemplate mongoTemplate) {
        Domain dentist = new Domain();
        dentist.setName("Stomatologie");
        dentist.setDescription("Stomatologie");
        mongoTemplate.save(dentist);
    }

}
