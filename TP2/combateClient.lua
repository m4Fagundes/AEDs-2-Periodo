local uis = game:GetService("UserInputService")

uis.inputBegan:Connect(function(input, gameProcessed)
    if input.KeyCode == Enum.KeyCode.E and not gameProcessed then 
    game.ReplicatedStorage:WaitForChild("Punch"):FireServer()
    end
end)
