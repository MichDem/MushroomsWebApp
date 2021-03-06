package pl.polsl.mushrooms.infrastructure.commands;

import pl.polsl.mushrooms.application.commands.ReturningCommand;

/**
 * Created by pawel_zaqkxkn on 26.03.2017.
 */
public class CommandGatewayImpl implements CommandGateway {


    private final CommandHandlerRegistry registry;

    public CommandGatewayImpl(CommandHandlerRegistry registry) {

        this.registry = registry;
    }

    @Override
    public <R> R dispatch(ReturningCommand<R> command) {
        return registry.get(command).handle(command);
    }
}
