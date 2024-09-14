package com.will_martin.domain;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component("doubleDateDiffService")
public class DoubleDateDiffService {
    final Logger logger;

    public DoubleDateDiffService() {
        logger = LoggerFactory.getLogger(DoubleDateDiffService.class);
    }

    public Date getDoubleDateDiff(Date dateOne, Date dateTwo) {
        List<Date> sortedDates = new java.util.ArrayList<>(List.of(dateOne, dateTwo));
        sortedDates.sort(Date::compareTo);
        Date dateFrom = sortedDates.get(0);
        Date dateTo = sortedDates.get(1);
        DateTime doubleDate = new DateTime(dateTo).plusDays(
                Days.daysBetween(new DateTime(dateFrom).toLocalDate(), new DateTime(dateTo).toLocalDate()).getDays()
        );
        logger.debug("Double date is: {}", doubleDate);
        return doubleDate.toDate();
    }
}
