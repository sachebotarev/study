//
//  ViewController.swift
//  Concentration
//
//  Created by Sergey Chebotarev on 24.09.2024.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var flipCountLabel: UILabel!
    
    @IBOutlet var cardButtons: [UIButton]!
    
    var emajiChoise = ["👻", "🎃", "👻", "🎃"]
    
    var flipCount:Int = 0 {
        didSet {
            flipCountLabel.text = "Flips: \(flipCount)"
        }
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func touchCard(_ sender: UIButton) {
        flipCount += 1
        guard let cardNumber = cardButtons.firstIndex(of: sender) else {
            return
        }
        flipCard(withEmoji: emajiChoise[cardNumber], on: sender)
    }
    

    func flipCard(withEmoji emoji:String, on button:UIButton){
        if button.currentTitle == emoji {
            button.setTitle("", for: UIControl.State.normal)
            button.backgroundColor = .orange
        } else {
            button.setTitle(emoji, for: UIControl.State.normal)
            button.backgroundColor = .white
        }
    }
}

