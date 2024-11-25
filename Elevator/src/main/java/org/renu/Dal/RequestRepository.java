package org.renu.Dal;

import org.renu.Model.Request;

import java.util.List;

public interface RequestRepository  {
    Request findRequestById(int requestId);
    List<Request> getAllRequests();
    void saveRequest(Request request);
    void updateRequest(Request request);
    void deleteRequest(int requestId);
}
