package org.pch.admin.remote.account;

import java.util.List;
import java.util.UUID;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@RegisterRestClient
public interface AccountService {

	@DELETE
	Response deleteClientAccounts(@QueryParam("clientId") UUID clientId);

	@GET
	List<AccountDTO> getClientAccounts(@QueryParam("clientId") UUID clientId);

}
