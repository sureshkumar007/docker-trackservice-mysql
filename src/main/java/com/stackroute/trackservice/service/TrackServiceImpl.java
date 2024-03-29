package com.stackroute.trackservice.service;


import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.repository.TrackRepository;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Profile("actual")
//Used to mark a class as the service provider.
public class TrackServiceImpl implements TrackService
{
    private TrackRepository trackRepository;

    @Autowired
    //Used to inject the dependency automatically.
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    //Used to override the parent class method, and to notify the mistakes.
    public Track saveTrack(Track track) throws TrackAlreadyExistsException
    {
        if(trackRepository.existsById(track.getId()))
        {
            throw new TrackAlreadyExistsException("existed");
        }
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public Track getTrackById(int id) throws TrackNotFoundException
    {
        if(trackRepository.existsById(id))
        {
            Track retrievedTrack = trackRepository.findById(id).get();
            return retrievedTrack;

        }
        else {
            throw new TrackNotFoundException("not founded");
        }

    }
    @Override
    public List<Track> getAllTracks()
    {

        List<Track> listTrack = trackRepository.findAll();
        return listTrack;
    }

    @Override
    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException
    {
        if(trackRepository.existsById(id))
        {
            Optional<Track> retrievedTrack = trackRepository.findById(id);
            trackRepository.deleteById(id);
            return retrievedTrack;
        }
        throw new TrackNotFoundException("delete exception");
    }

    @Override
    public Track updateTrack(int id, Track track) throws TrackNotFoundException
    {
        if(trackRepository.existsById(id))
        {
            Track trackBeforeUpdate = trackRepository.findById(id).get();
            track.setComments(track.getComments());
            track.setName(track.getName());
            return trackRepository.save(track);
        }
        throw new TrackNotFoundException("update failed");

    }

    @Override
    public List<Track> getByName(String name) throws TrackNotFoundException
    {
        List<Track> trackByName=trackRepository.findByTrackName(name);
        if(trackByName.isEmpty())
        {
            throw new TrackNotFoundException("get by name not found");
        }
        return trackByName;
    }

}

