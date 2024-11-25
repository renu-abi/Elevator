package org.renu.InMemoryRepository;

import org.renu.Dal.RequestRepository;
import org.renu.Model.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryRequestRepository implements RequestRepository {
    private ConcurrentHashMap<Integer, Request> reqMap = new ConcurrentHashMap<>();

    @Override
    public Request findRequestById(int requestId) {
        return reqMap.get(requestId);
    }

    @Override
    public List<Request> getAllRequests() {
        return new ArrayList<>(reqMap.values());//return a copy of all request
    }

    @Override
    public void saveRequest(Request request) {
        reqMap.put(request.getRequestId(), request);// add request to map
    }

    @Override
    public void updateRequest(Request request) {
        reqMap.put(request.getRequestId(), request); //update the request
    }

    @Override
    public void deleteRequest(int requestId) {
        reqMap.remove(requestId); //remove request by id
    }
}
