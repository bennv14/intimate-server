package com.intimate.server.controller;

import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.intimate.server.service.FirebaseAuthService;
import com.intimate.server.service.FirestoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/firebase")
public class FirebaseController {
    @Autowired
    private FirebaseAuthService firebaseAuthService;
    @Autowired
    private FirestoreService firestoreService;

    
    @GetMapping("/verifyToken")
    public FirebaseToken verifyToken(@RequestParam String idToken) throws FirebaseAuthException {
        return firebaseAuthService.verifyToken(idToken);
    }

    @GetMapping("/getCollection")
    public QuerySnapshot getCollection(@RequestParam String collectionName) throws ExecutionException, InterruptedException {
        return firestoreService.getCollection(collectionName);
    }
}