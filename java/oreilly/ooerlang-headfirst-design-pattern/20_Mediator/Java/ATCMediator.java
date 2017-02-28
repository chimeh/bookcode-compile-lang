//Este fonte foi retirado de: http://javapapers.com/design-patterns/mediator-design-pattern
//Ultimo acesso em Agosto de 2013

public class ATCMediator implements IATCMediator {
	private Flight flight;
	private Runway runway;
	public boolean land;

	public void registerRunway(Runway runway) {
		this.runway = runway;
	}

	public void registerFlight(Flight flight) {
		this.flight = flight;
	}

	public boolean isLandingOk() {
		return land;
	}

	public void setLandingStatus(boolean status) {
		land = status;

	}
}
