package ru.study.codesharing.services;

import java.security.Principal;

public interface StarsService {

    boolean setStarToGist(long gistId, Principal principal);
}
