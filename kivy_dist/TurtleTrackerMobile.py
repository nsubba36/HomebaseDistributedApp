# import kivy packages
from kivy.app import App
from kivy.uix.gridlayout import GridLayout
from kivy.uix.label import Label
from kivy.uix.button import Button
# import packages to parse xml
import urllib
import urllib.request

class TurtleTrackerMobile(App):
    def build(self):
        # top part of screen has 1 column for the button
        self.window = GridLayout()
        self.window.cols = 1
        self.button = Button(text="Refresh", )  # create refresh button
        self.button.bind(on_press=self.getdata) # link button pretty be method
        self.window.add_widget(self.button)     # add button to window
        self.colum_grid = GridLayout()          # make second area with 5 columns
        self.colum_grid.cols = 5
        self.window.add_widget(self.colum_grid) # add area to window

        # make a label for each column for the data.  Add to area with 5 columns
        self.breedlb = Label()
        self.colum_grid.add_widget(self.breedlb)
        self.locationlb = Label()
        self.colum_grid.add_widget(self.locationlb)
        self.healthlb = Label()
        self.colum_grid.add_widget(self.healthlb)
        self.lengthlb = Label()
        self.colum_grid.add_widget(self.lengthlb)
        self.weightlb = Label()
        self.colum_grid.add_widget(self.weightlb)
      
        return self.window

    def getdata(self, instance):
        # this is the method to call the xml and put data in labels
        url = "http://localhost:8080/TurtleTracker/webresources/entity.specimen"
    
        xmlfile = urllib.request.urlopen(url)  # get url
        xmltextr = xmlfile.read()              # read it
        xmltext = str(xmltextr)                # put in string
        # load labels for each label
        self.breedlb.text = "Breed\n"
        self.locationlb.text = "Location\n"
        self.healthlb.text = "Health\n"
        self.lengthlb.text = "Length\n"
        self.weightlb.text = "Weight\n"

        # Each time we look we'll put the top turtle data. Then we remove it,
        #  so variable xmltext gets smaller and smaller 
        while len(xmltext) > 25:
            # append data to botton of label
            self.breedlb.text = self.breedlb.text + xmltext[xmltext.find('<breedCode>')+11:xmltext.find('</breedCode>')] + "\n"
            self.locationlb.text = self.locationlb.text + xmltext[xmltext.find('<locationCode>')+14:xmltext.find('</locationCode>')] + "\n"
            self.healthlb.text = self.healthlb.text + xmltext[xmltext.find('<specimenHealth>')+16:xmltext.find('</specimenHealth>')] + "\n"
            self.lengthlb.text = self.lengthlb.text + xmltext[xmltext.find('<specimenLength>')+16:xmltext.find('</specimenLength>')] + "\n"
            self.weightlb.text = self.weightlb.text + xmltext[xmltext.find('<specimenWeight>')+16:xmltext.find('</specimenWeight>')] + "\n"
            xmltext = xmltext[xmltext.find('</specimenWeight>')+20:] # make xmltext smaller

# this calls the app when you run it    
if __name__ == "__main__":
    TurtleTrackerMobile().run()
