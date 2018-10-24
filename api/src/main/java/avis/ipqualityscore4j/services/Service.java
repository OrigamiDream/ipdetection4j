package avis.ipqualityscore4j.services;

import avis.ipqualityscore4j.components.Request;
import avis.ipqualityscore4j.components.Response;

import java.util.concurrent.Future;

public interface Service<R extends Response, Q extends Request> {

    Future<R> execute(Q q);

}
