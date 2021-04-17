package com.trilogyed.rsvp.controller;

import com.trilogyed.rsvp.dao.RsvpDao;
import com.trilogyed.rsvp.model.Rsvp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CacheConfig(cacheNames = {"rsvps"})
public class RsvpController {

    // Adding comment to test command line heroku deploy

    @Autowired
    RsvpDao dao;

    public RsvpController(RsvpDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/rsvps", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Rsvp createRsvp(@RequestBody Rsvp rsvp) {
        System.out.println("CREATING RSVP");
        return dao.addRsvp(rsvp);
    }

    @RequestMapping(value = "/rsvps/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Rsvp getRsvp(@PathVariable int id) {
        System.out.println("GETTING RSVP ID = " + id);
        return dao.getRsvp(id);
    }

    @RequestMapping(value = "/rsvps", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Rsvp> getAllRsvps() {
        System.out.println("GETTING ALL RSVPS");
        return dao.getAllRsvps();
    }

    @RequestMapping(value = "/rsvps", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateRsvp(@RequestBody Rsvp rsvp) {
        System.out.println("UPDATING RSVP ID = " + rsvp.getRsvpId());
        dao.updateRsvp(rsvp);
    }

    @RequestMapping(value = "/rsvps/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteRsvp(@PathVariable int id) {
        System.out.println("DELETING RSVP ID = " + id   );
        dao.deleteRsvp(id);
    }

}
