package com.intimate.server.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FirestoreService {
    private final Firestore db;

    public FirestoreService() {
        this.db = FirestoreOptions.getDefaultInstance().getService();
    }

    public QuerySnapshot getCollection(String collectionName) throws ExecutionException, InterruptedException {
        CollectionReference collection = db.collection(collectionName);
        ApiFuture<QuerySnapshot> querySnapshot = collection.get();
        return querySnapshot.get();
    }
}