package fr.eni.potager.ws;

import fr.eni.potager.bll.BLLManagerException;
import fr.eni.potager.bll.MainManager;
import fr.eni.potager.bo.Carre;
import fr.eni.potager.bo.Potager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/MonPotager")
public class PotagerWS {

    @Autowired
    MainManager manager;

    @PostMapping("/potager")
    @ResponseStatus(HttpStatus.CREATED)
    public Potager createPotager(@RequestBody @Valid Potager potager) throws BLLManagerException {
        return manager.saveOrUpdatePotager(potager);
    }

    @GetMapping("/potager/{id}")
    public Potager getPotagerById(@PathVariable("id") Integer id) throws BLLManagerException {
       return manager.getPotagerById(id);
    }

    @GetMapping("/potager")
    public List<Potager> getAllPotagers() {
        return manager.getAllPotager();
    }

    @PutMapping("/potager")
    public Potager updatePotager(@RequestBody Potager potager) throws Exception {
        if (null == potager.getId()) {
            throw new Exception("impossible de modifier un potager qui n'est pas dans la base");
        }
        return manager.saveOrUpdatePotager(potager);
    }

    @DeleteMapping("/potager")
    public void deletePotager(@RequestBody Potager potager) {
        manager.deletePotager(potager);
    }

    @PostMapping("/{id}/carre")
    void addCarreIntoPotager(@PathVariable Integer potagerId, @RequestBody Carre carre) throws BLLManagerException {
        manager.addCarreIntoPotager(carre);
    }

    @GetMapping("/{idPotager}/carre/{idCarre}")
    void getCarreById(@PathVariable Integer idCarre) throws BLLManagerException {
        manager.getCarreById(idCarre);
    }

    @GetMapping("/{id}/carre")
    void getAllCarreFromPotager (@PathVariable Integer id) throws BLLManagerException {
        Potager potager = manager.getPotagerById(id);
        manager.getAllCarreFromPotager(potager);
    }
}
