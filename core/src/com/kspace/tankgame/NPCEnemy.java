package com.kspace.tankgame;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class NPCEnemy extends Player
{
	NPCEnemy()
	{
		
	}
	
	NPCEnemy(AssetManager amgr, Color color)
	{	
		super(amgr, color);
	}
	
	public void tick(Map bg, Player player)
	{
		rotation = (float) -Math.toDegrees(Math.atan2(position.x - player.position.x, position.y - player.position.y));
		
		float distance = Vector2.dst(position.x, position.y, player.position.x, player.position.y);
		float targetDirection = 0;
		
		if (distance < 1024)
		{
			fire(0);
		}
		
		if (distance <= 768 && distance >= 512) targetDirection = (float) -Math.toDegrees(Math.atan2(position.x - player.position.x, position.y - player.position.y)) + 90;
		else if (distance < 512) targetDirection = (float) -Math.toDegrees(Math.atan2(position.x - player.position.x, position.y - player.position.y));
		else targetDirection = (float) -Math.toDegrees(Math.atan2(position.x - player.position.x, position.y - player.position.y)) + 180;
		
		direction = lerp(direction, targetDirection, 0.01f);
		
		checkForHits(player.getProjectiles());
		player.checkForHits(getProjectiles());
		
		move(bg, 130);
	}
}
