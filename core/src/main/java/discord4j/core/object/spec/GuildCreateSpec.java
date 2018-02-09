/*
 * This file is part of Discord4J.
 *
 * Discord4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Discord4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Discord4J.  If not, see <http://www.gnu.org/licenses/>.
 */
package discord4j.core.object.spec;

import discord4j.common.json.request.GuildCreateRequest;
import discord4j.common.json.request.PartialChannelRequest;
import discord4j.common.json.request.RoleCreateRequest;
import discord4j.core.object.Region;
import discord4j.core.object.entity.Channel;
import discord4j.core.object.entity.Guild;

import java.util.ArrayList;
import java.util.List;

public class GuildCreateSpec implements Spec<GuildCreateRequest> {

	private String name;
	private String region;
	private String icon;
	private int verificationLevel;
	private int defaultMessageNoficationLevel;
	private final List<RoleCreateRequest> roles = new ArrayList<>();
	private final List<PartialChannelRequest> channels = new ArrayList<>();

	public GuildCreateSpec setName(String name) {
		this.name = name;
		return this;
	}

	public GuildCreateSpec setRegion(Region region) {
		this.region = region.getId();
		return this;
	}

	public GuildCreateSpec setIcon(String icon) { // TODO icon class
		this.icon = icon;
		return this;
	}

	public GuildCreateSpec setVerificationLevel(Guild.VerificationLevel verificationLevel) {
		this.verificationLevel = verificationLevel.getValue();
		return this;
	}

	public GuildCreateSpec setDefaultMessageNoficiationLevel(Guild.NotificationLevel noficiationLevel) {
		this.defaultMessageNoficationLevel = noficiationLevel.getValue();
		return this;
	}

	public GuildCreateSpec addRole(RoleCreateSpec roleSpec) {
		roles.add(roleSpec.asRequest());
		return this;
	}

	public GuildCreateSpec addEveryoneRole(RoleCreateSpec roleSpec) {
		roles.add(0, roleSpec.asRequest());
		return this;
	}

	public GuildCreateSpec addChannel(String name, Channel.Type type) {
		channels.add(new PartialChannelRequest(name, type.getValue()));
		return this;
	}

	@Override
	public GuildCreateRequest asRequest() {
		RoleCreateRequest[] roles = this.roles.toArray(new RoleCreateRequest[this.roles.size()]);
		PartialChannelRequest[] channels = this.channels.toArray(new PartialChannelRequest[this.channels.size()]);
		return new GuildCreateRequest(name, region, icon, verificationLevel, defaultMessageNoficationLevel, roles,
				channels);
	}
}
