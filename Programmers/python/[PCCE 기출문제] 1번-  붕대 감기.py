def extractAttackTimes(attacks):
    attack_times = []
    for i in range(len(attacks)):
        attack_times.append(attacks[i][0])
    return attack_times


def put_bandage(cur_health, heal_amt, heal_sec, full_health):
    cur_health += heal_amt
    
    if cur_health >= full_health:
        return full_health, heal_sec
    
    heal_sec += 1
    return cur_health, heal_sec


def bonus_bandage(cur_health, heal_sec, heal_time, bonus_heal):
    if heal_sec >= heal_time:
        cur_health += bonus_heal
        heal_sec = 0
        
    return cur_health, heal_sec


def solution(bandage, health, attacks):
    full_health = health
    heal_time = bandage[0]
    heal_amt = bandage[1]
    bonus_heal = bandage[2]

    attack_times = extractAttackTimes(attacks);
    last_attack_sec = attack_times[len(attack_times) - 1]
    attack_step = 0;
    
    cur_health = int(health);
    sec = 0;
    heal_sec = 0;
    
    while sec <= last_attack_sec:
        sec += 1;
        
        # 공격이 있을 때
        if sec in attack_times:
            heal_sec = 0 # 붕대감기 시간 0초로 초기화
            cur_health -= attacks[attack_step][1];
            attack_step += 1
        
            # 공격 이후 체력이 0 이하가 되었을 때 -1 반환
            if cur_health <= 0:
                return -1;
            
            if sec >= last_attack_sec:
                break
            
            continue
        
        
        # 공격이 없을 때
        cur_health, heal_sec = put_bandage(cur_health, heal_amt, heal_sec, full_health)
        cur_health, heal_sec = bonus_bandage(cur_health, heal_sec, heal_time, bonus_heal)
    
    return cur_health;
