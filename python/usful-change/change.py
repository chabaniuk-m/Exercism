import math

_main_call = False
_max_depth = 0
_counter = 0
_max_count = 100


def find_fewest_coins(coins, target, recursive_call=False, depth=0, prev=math.inf):
    if target < 0:
        raise ValueError("target can't be negative")
    if target == 0:
        return []
    if coins == [1, 5, 10, 21, 25]:
        print()

    global _main_call, _max_depth, _counter, _max_count
    if not recursive_call:
        _main_call = True
        coins = sorted(coins)
        _max_depth = math.inf
    if not _main_call and depth == _max_depth:
        _counter += 1
        return []

    max_coin_idx = 0
    for i in range(1, len(coins)):
        if coins[max_coin_idx] < coins[i] <= target and coins[i] <= prev:
            max_coin_idx = i
    max_coin = coins[max_coin_idx]
    # if the smallest coin is greater than the target
    if max_coin > target:
        if recursive_call:
            return []
        else:
            print(f"{target=}\n{coins=}")
            raise ValueError("can't make target with given coins")
    if max_coin == target:
        if recursive_call:
            if _main_call:
                _main_call = False
                _max_depth = depth
                _counter = 0
            if depth < _max_depth:
                _max_depth = depth
            _counter += 1
            return [[max_coin]]
        else:
            print(f"{target=}\n{coins=}")
            return [max_coin]

    res = []
    while max_coin_idx >= 0:
        if depth == _max_depth - 1 or _counter > _max_count:
            # print("\nMAX COUNT EXCEEDED\n")
            break
        if recursive := find_fewest_coins(coins, target - max_coin, True, depth + 1, max_coin):
            for row in recursive:
                res.append([max_coin] + row)
        max_coin_idx -= 1
        max_coin = coins[max_coin_idx] if max_coin_idx >= 0 else 0
    if recursive_call:
        return res
    else:
        print(f"{target=}\n{coins=}")
        if not res:
            raise ValueError("can't make target with given coins")
        return list(sorted(min(res, key=len)))
