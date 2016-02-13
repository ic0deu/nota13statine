/**
 * Created by amasucci on 11/02/16.
 */

package i.c0d.eu.nota13statine;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.TemporalUnit;
import java.util.Optional;

@RestController
public class HelloController {

    @RequestMapping("/ldl")
    public Double calc(@RequestParam(value="totale", defaultValue="0") String totale,
                       @RequestParam(value="ldl", defaultValue="0") String ldl,
                       @RequestParam(value="trigliceridi", defaultValue="0") String trigliceridi) {
        //Colesterolo LDL = colesterolo totale - (colesterolo HDL + (trigliceridemia/5))
        return Double.parseDouble(totale) - (Double.parseDouble(ldl) + Double.parseDouble(trigliceridi)/5);
    }

    @RequestMapping("/date")
    public Long calc(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                           @RequestParam(value = "dob") LocalDate dob) {
        //Colesterolo LDL = colesterolo totale - (colesterolo HDL + (trigliceridemia/5))
        return Duration.between(LocalDate.now(), dob).toDays()/365;
    }

    /*

    * eta o data di nascita,
    * sesso,
    *
    * [colesterolo totale
    * hdl
    * trigliceridi
    * parametri per calcolo ldl]
    *
    * indice di rischio =( colesterolo totale / ldl )
    * maschio < 5
    * donna < 4,5
    *
    * pressione massima, minima e hdl
    * */


}
