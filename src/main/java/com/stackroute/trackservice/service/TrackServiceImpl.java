package com.stackroute.trackservice.service;


import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repository.TrackRepository;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
//Used to mark a class as the service provider.
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    @Autowired
    //Used to inject the dependency automatically.
    public TrackServiceImple(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    //Used to override the parent class method, and to notify the mistakes.
    public Track saveTrack(Track track) {
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public Track getTrackById(int id) {
        Track retrievedTrack = trackRepository.findById(id).get();
        return retrievedTrack;
    }

    @Override
    public List<Track> getAllTracks() {
        List<Track> listTrack = trackRepository.findAll();
        return listTrack;
    }

    @Override
    public Optional<Track> deleteTrackById(int id) {
        Optional<Track> retrievedTrack = trackRepository.findById(id);
        if (retrievedTrack.isPresent()){
            trackRepository.deleteById(id);
        }
        return retrievedTrack;
    }

    @Override
    public Track updateTrack(int id, Track track) {
        Track trackBeforeUpdate = trackRepository.findById(id).get();
        track.setComments(track.getComments());
        track.setName(track.getName());
        return trackRepository.save(track);
    }
}

