package com.miwa.time.ParserCron;

import com.cronutils.model.Cron;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.time.ExecutionTime;
import com.cronutils.parser.CronParser;
import com.cronutils.validator.CronValidator;
import org.joda.time.DateTime;

import java.util.Date;


/**
 * Created by BadaBoum on 15/11/2015.
 */
public class ParseCron {
//https://github.com/jmrozanec/cron-utils
    CronDefinition cronDefinition;
    public ParseCron() {
        //create a parser based on provided definition
        cronDefinition =
                CronDefinitionBuilder.defineCron()
                        .withSeconds().and()
                        .withMinutes().and()
                        .withHours().and()
                        .withDayOfMonth()
                        .supportsHash().supportsL().supportsW().and()
                        .withMonth().and()
                        .withDayOfWeek()
                        .withIntMapping(7, 0) //we support non-standard non-zero-based numbers!
                        .supportsHash().supportsL().supportsW().and()
                        .withYear().and()
                        .lastFieldOptional()
                        .instance();
    }

    public Cron parse(String message) {
        //Validate if a string expression matches a cron definition:
        CronValidator quartzValidator = new CronValidator(cronDefinition);

        //getting a boolean result:
        if (quartzValidator.isValid(message)) {
        CronParser parser = new CronParser(cronDefinition);

        Cron cron = parser.parse(message);

        return cron;
        }
        return null;
    }

    public Date nextExecution(Date now, Cron cronMessage){

        DateTime dtNow = new DateTime(now);
//Get date for last execution
        ExecutionTime executionTime = ExecutionTime.forCron(cronMessage);
//Get date for next execution
        DateTime nextExecution = executionTime.nextExecution(dtNow);

        return nextExecution.toDate();
    }
}
