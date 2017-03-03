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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.plugin.meta.PluginDependency;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * The plugin metadata.
 */
public final class PluginMeta {

    static {
        //noinspection ConstantConditions
        CONTAINER = Sponge.getPluginManager().getPlugin(PluginMeta.ID).get();
    }

    private static final String UNKNOWN = "unknown";

    /**
     * The Foundations API version.
     */
    public static final String API = "@API@";

    /**
     * The Foundations API version as long so as to compare numerically.
     */
    public static final long API_INCREMENTAL;

    /**
     * The authors for the plugin.
     */
    public static final List<String> AUTHORS = ImmutableList.copyOf(PluginMeta.CONTAINER.getAuthors());

    /**
     * The plugin container.
     */
    public static final PluginContainer CONTAINER;

    /**
     * The dependencies for the plugin.
     */
    @SuppressWarnings("ConstantConditions")
    public static final Set<PluginDependency> DEPENDENCIES = ImmutableSet.copyOf(CONTAINER.getDependencies());

    /**
     * The description for the plugin.
     */
    public static final String DESCRIPTION = PluginMeta.CONTAINER.getDescription().orElse(UNKNOWN);

    /**
     * The discord invite url.
     */
    public static final String DISCORD_URL = "@DISCORD_URL@";

    /**
     * The documentation site url.
     */
    public static final String DOC_URL = PluginMeta.URL + "/" + PluginMeta.ID;

    /**
     * The foundations plugin repository url.
     */
    public static final String GITHUB_REPO_URL = "@GITHUB_REPO_URL@";

    /**
     * The foundations issues url.
     */
    public static final String GITHUB_REPO_ISSUES_URL = GITHUB_REPO_URL + "/issues";

    /**
     * The git SHA hash for the HEAD when the plugin was built.
     */
    public static final String GIT_HASH = "@GIT_HASH@";

    /**
     * The id for the plugin.
     */
    // Won't change.
    public static final String ID = "foundations";

    /**
     * The plugin instance.
     */
    // Plugin won't work anyways if the plugin isn't functional
    @SuppressWarnings("ConstantConditions")
    public static final FoundationsPlugin INSTANCE = (FoundationsPlugin) CONTAINER.getInstance().get();

    /**
     * The plugin name.
     */
    public static final String NAME = PluginMeta.CONTAINER.getName();

    /**
     * The Sponge API version.
     */
    @SuppressWarnings("ConstantConditions")
    public static final String SPONGE_API_VERSION = CONTAINER.getDependency("spongeapi").get().getVersion();

    /**
     * The Sponge API version as long so as to compare numerically.
     */
    public static final long SPONGE_API_VERSION_INCREMENTAL;

    /**
     * The default plugin logger.
     */
    // Plugin won't work anyways if the plugin isn't functional
    @SuppressWarnings("ConstantConditions")
    public static final Logger SPONGE_PLUGIN_LOGGER = CONTAINER.getLogger();

    /**
     * The pxlpowered website url.
     */
    public static final String URL = PluginMeta.CONTAINER.getUrl().orElse(UNKNOWN);

    /**
     * The plugin version.
     */
    public static final String VERSION = PluginMeta.CONTAINER.getVersion().orElse("0.0.0");

    /**
     * The Foundations version as long so as to compare numerically.
     */
    public static final long VERSION_INCREMENTAL;

    // Do not initialize
    private PluginMeta() {
    }

    static {
        final long million = 1_000_000;
        final long thousand = 1_000;

        Long[] tmpVers = Arrays.stream(API.replaceAll("-SNAPSHOT", "").split("\\.")).map(Long::parseLong)
                .toArray(Long[]::new);
        API_INCREMENTAL = (tmpVers[0] * million) + (tmpVers[1] * thousand) + (tmpVers[2]);

        tmpVers = Arrays.stream(VERSION.replaceAll("-SNAPSHOT", "").split("\\.")).map(Long::parseLong)
                .toArray(Long[]::new);
        VERSION_INCREMENTAL = (tmpVers[0] * million) + (tmpVers[1] * thousand) + (tmpVers[2]);

        tmpVers = Arrays.stream(SPONGE_API_VERSION.replaceAll("-SNAPSHOT", "").split("\\.")).map(Long::parseLong)
                .toArray(Long[]::new);
        SPONGE_API_VERSION_INCREMENTAL = (tmpVers[0] * million) + (tmpVers[1] * thousand) + (tmpVers[2]);
    }

}
