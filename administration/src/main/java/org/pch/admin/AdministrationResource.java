package org.pch.admin;

import java.util.List;
import java.util.UUID;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.pch.admin.remote.account.AccountDTO;
import org.pch.admin.remote.account.AccountService;
import org.pch.admin.remote.client.ClientDTO;
import org.pch.admin.remote.client.ClientService;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("administration")
public class AdministrationResource {

	private static final Logger LOG = Logger.getLogger(AdministrationResource.class);

	@RestClient
	private ClientService clientService;

	@RestClient
	private AccountService accountService;

	@GET
	@Path("clients")
	public List<ClientDTO> getClients() {
		List<ClientDTO> clients = clientService.getClients();
		return clients;
	}

	@GET
	@Path("clients/{id}")
	public ClientDTO getClient(@PathParam("id") UUID clientId) {
		ClientDTO client = clientService.getClient(clientId);
		return client;
	}

	@DELETE
	@Path("clients/{id}")
	public void deleteClient(@PathParam("id") UUID clientId) {
		LOG.info("Deleting client " + clientId);
		clientService.deleteClient(clientId);
		accountService.deleteClientAccounts(clientId);
	}

	@GET
	@Path("clients/{id}/accounts")
	public List<AccountDTO> getClientAccounts(@PathParam("id") UUID clientId) {
		List<AccountDTO> accounts = accountService.getClientAccounts(clientId);
		return accounts;
	}

}
