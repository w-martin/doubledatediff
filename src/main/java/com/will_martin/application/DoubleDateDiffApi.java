package com.will_martin.application;

import com.will_martin.model.DoubleDateDiffService;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@Builder
@RestController
public class DoubleDateDiffApi {
    private static final String YYYY_MM_DD = "yyyy-MM-dd";
    private final SimpleDateFormat formatter = new SimpleDateFormat(YYYY_MM_DD);
    private final DoubleDateDiffService doubleDateDiffService;

    @GetMapping(value = "/doubledatediff/{dateOne}/{dateTwo}")
    public ResponseEntity<String> getDoubleDateDiff(@PathVariable @DateTimeFormat(pattern = YYYY_MM_DD) Date dateOne,
                                                    @PathVariable @DateTimeFormat(pattern = YYYY_MM_DD) Date dateTwo) {
        final Date result = doubleDateDiffService.getDoubleDateDiff(dateOne, dateTwo);
        return ResponseEntity.ok(formatter.format(result));
    }
}
