package com.will_martin.domain;

import com.will_martin.model.DoubleDateDiffService;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service("doubleDateDiffService")
public class JodaDoubleDateDiffService implements DoubleDateDiffService {

    @Cacheable(keyGenerator = "dateKeyGenerator", value = "getDoubleDateDiffUnsorted")
    public Date getDoubleDateDiff(Date dateOne, Date dateTwo) {
        List<Date> sortedDates = new java.util.ArrayList<>(List.of(dateOne, dateTwo));
        sortedDates.sort(Date::compareTo);
        Date dateFrom = sortedDates.get(0);
        Date dateTo = sortedDates.get(1);
        return getDoubleDateDiffSorted(dateTo, dateFrom);
    }

    @Cacheable(keyGenerator = "dateKeyGenerator", value = "getDoubleDateDiffSorted")
    public Date getDoubleDateDiffSorted(final Date dateTo, final Date dateFrom) {
        DateTime doubleDate = new DateTime(dateTo).plusDays(
                Days.daysBetween(new DateTime(dateFrom).toLocalDate(), new DateTime(dateTo).toLocalDate()).getDays()
        );
        log.info("Double date is: {}", doubleDate);
        return doubleDate.toDate();
    }
}
