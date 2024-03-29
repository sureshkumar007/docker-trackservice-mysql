package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import org.springframework.context.annotation.Profile;

import java.util.List;
import java.util.Optional;
@Profile("dummy2")
public class TrackDummyServiceImple implements TrackService {
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        return null;
    }

    @Override
    public Track getTrackById(int id) throws TrackNotFoundException {
        return null;
    }

    @Override
    public List<Track> getAllTracks() {
        return null;
    }

    @Override
    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException {
        return Optional.empty();
    }

    @Override
    public Track updateTrack(int id, Track track) throws TrackNotFoundException {
        return null;
    }

    @Override
    public List<Track> getByName(String name) throws TrackNotFoundException {
        return null;
    }
}
