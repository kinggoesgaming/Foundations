/*
 * This file is part of foundations, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2017 - 2017 PxL Powered <https://pxlpowered.github.io>
 * Copyright (c) Contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package io.github.pxlpowered.foundations.plugin;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.slf4j.Logger;
import org.spongepowered.api.GameState;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.game.state.GameStoppingEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

/**
 * The main class for foundations plugin.
 */
@Plugin(
        id = PluginMeta.ID
    )
public final class FoundationsPlugin {

    private final PluginContainer pluginContainer;

    @Inject private Logger logger;
    @Inject private Injector injector;

    @Inject
    private FoundationsPlugin(PluginContainer pluginContainer) {
        this.pluginContainer = pluginContainer;
    }

    /**
     * The game preinitialization tasks.
     *
     * @param event The {@link GamePreInitializationEvent} instance.
     * @param state The {@link GameState} derived from
     *     {@link GamePreInitializationEvent#getState()}.
     */
    @Listener
    public void onPreInit(final GamePreInitializationEvent event, @Getter("getState") GameState state) {
        // TODO switch to internal messages mechanism
        logger.info("Starting up foundations");
    }

    /**
     * The actions to do at normal shutdown of the server and plugin.
     *
     * @param event The {@link GameStoppingEvent} instance.
     * @param state The {@link GameState} derived from
     *     {@link GameStoppingEvent#getState()}.
     */
    @Listener
    public void onStopping(final GameStoppingEvent event, @Getter("getState") GameState state) {
        // TODO switch to internal messages mechanism
        logger.info("Stopping foundations");
    }

    /**
     * Gets the {@link PluginContainer} for the plugin.
     *
     * @return The plugin container.
     */
    public PluginContainer getPluginContainer() {
        return pluginContainer;
    }

    /**
     * Gets the current global {@link Logger} for the plugin.
     *
     * @return The logger
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * Gets the {@link Injector} for the plugin.
     *
     * @return The injector.
     */
    public Injector getInjector() {
        return injector;
    }

}
